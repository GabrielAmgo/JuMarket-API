package com.JuMarket.autoatendimento.JuMarket.service.impl

import com.JuMarket.autoatendimento.JuMarket.entity.Sale
import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import com.JuMarket.autoatendimento.JuMarket.repository.SaleRepository
import com.JuMarket.autoatendimento.JuMarket.service.ISaleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SaleService(
        private val saleRepository: SaleRepository,
        @Autowired
        private val cartService: CartService,
) : ISaleService {

    override fun calculateTotalValue(cartId: Int): String {
        val cart = cartService.findById(cartId)
        var totalValue = BigDecimal.ZERO

        for (cartItem in cart.cartItems) {
            val product = cartItem.product
            val amount = cartItem.amount
            val itemPrice = product.price.multiply(BigDecimal(amount))
            totalValue = totalValue.add(itemPrice)
        }

        return "Your cart total value is R$${totalValue}"
    }

    override fun paymentMethod(cartId: Int, paymentMethod: PaymentMethod): String {
        val cart = cartService.findById(cartId)
        cart.paymentMethod = paymentMethod
        cartService.save(cart)
        return "Thank you for buying with us! Your cart $cartId has been paid with $paymentMethod!"
    }

    override fun findById(id: Int): Sale =
            this.saleRepository.findById(id).orElseThrow {
                throw RuntimeException("Sale $id not found")
            }

    override fun findAll(): List<Sale> =
            this.saleRepository.findAll()
}


