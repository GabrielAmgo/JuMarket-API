package com.JuMarket.autoatendimento.JuMarket.service.impl


import com.JuMarket.autoatendimento.JuMarket.dto.CartItemDto
import com.JuMarket.autoatendimento.JuMarket.dto.CartItemInfoDto
import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.CartItem
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import com.JuMarket.autoatendimento.JuMarket.repository.CartItemRepository
import com.JuMarket.autoatendimento.JuMarket.repository.CartRepository
import com.JuMarket.autoatendimento.JuMarket.repository.ProductRepository
import com.JuMarket.autoatendimento.JuMarket.service.ICartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CartService(
    private val productRepository: ProductRepository,
    private val cartRepository: CartRepository,
    private val cartItemRepository: CartItemRepository,
    @Autowired
    var cartItems: MutableMap<Long?, MutableList<Pair<Product, Int>>>,
): ICartService {

    override fun save(cart: Cart) {
        cartRepository.save(cart)
    }
    override fun addItem(cartId: Long?, productId: Long, amount: Int) {
        val cart = getOrCreateCart(cartId)

        val product = productRepository.findById(productId).orElseThrow {
            throw RuntimeException("Product with ID $productId not found")
        }

        val existingItem = cartItems.getOrPut(cart.id) { mutableListOf() }.find { it.first.id == productId }
        if (existingItem != null) {
            val updatedQuantity = existingItem.second + amount
            cartItems[cart.id]?.remove(existingItem)
            cartItems[cart.id]?.add(Pair(product, updatedQuantity))
        } else {
            cartItems[cart.id]?.add(Pair(product, amount))
        }
        cart.cartItems.clear()
        cartItems[cart.id]?.forEach { (product, amount) ->
            val cartItem = CartItem(cart = cart, product = product, amount = amount)
            cart.cartItems.add(cartItem)
        }
        cartRepository.save(cart)
    }


    override fun removeItem(productId: Long, amount: Int) {
        cartItems.forEach { (cartId, items) ->
            val existingItem = items.find { it.first.id == productId }
            existingItem?.let {
                val updatedQuantity = it.second - amount
                if (updatedQuantity <= 0) {
                    items.remove(existingItem)
                } else {
                    items[items.indexOf(existingItem)] = Pair(it.first, updatedQuantity)
                }
                cartId?.let { cartId ->
                    val cart = cartRepository.findById(cartId).orElseThrow {
                        throw RuntimeException("Cart with ID $cartId not found")
                    }
                    cart.cartItems.clear()
                    cartItems[cart.id]?.forEach { (product, amount) ->
                        val cartItem = CartItem(cart = cart, product = product, amount = amount)
                        cart.cartItems.add(cartItem)
                    }
                    cartRepository.save(cart)
                }
            }
        }
    }

    override fun displayCart(): Pair<Long?, List<CartItemInfoDto>> {
        val cartId: Long? = cartItems.keys.firstOrNull()
        val cartItemsInfo = cartItems.flatMap { (_, items) -> items }
            .map { getCartItemInfo(it) }
        return Pair(cartId, cartItemsInfo)
    }

    private fun getCartItemInfo(cartItem: Pair<Product, Int>): CartItemInfoDto {
        val (product, amount) = cartItem
        val price = product.price.multiply(BigDecimal(amount))
        return CartItemInfoDto(
                productId = product.id ?: 0,
                productName = product.productName,
                amount = amount,
                unitPrice = product.price,
                amountPrice = price,
        )
    }

    override fun findById(id: Long): Cart =
            this.cartRepository.findById(id).orElseThrow{
                throw RuntimeException ("Id $id not found")
            }

    override fun clearCart(){
        cartItems.clear()
    }

    private fun getOrCreateCart(cartId: Long?): Cart {
        return cartId?.let {
            cartRepository.findById(it).orElseGet {
                val newCart = Cart()
                cartRepository.save(newCart)
            }
        } ?: run {
            val newCart = Cart()
            cartRepository.save(newCart)
        }
    }
}