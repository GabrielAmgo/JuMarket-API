package com.JuMarket.autoatendimento.JuMarket.service.impl

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.repository.CartItemRepository
import com.JuMarket.autoatendimento.JuMarket.repository.CartRepository
import com.JuMarket.autoatendimento.JuMarket.repository.ProductRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.math.BigDecimal
import java.util.*

class CartServiceTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    @Mock
    private lateinit var cartRepository: CartRepository

    @Mock
    private lateinit var cartItemRepository: CartItemRepository

    @InjectMocks
    private lateinit var cartService: CartService

    private var cartItems: MutableMap<Long?, MutableList<Pair<Product, Int>>> = mutableMapOf()

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testAddItem() {
        // Arrange
        val productId = 1L
        val productName = "Product 1"
        val productPrice = BigDecimal("10.0")
        val cartId = 1L
        val amount = 2
        val category = Category(1,"Test")

        val product = Product(1, "Test Product", "500g", category = Category(category.id, name = "Test Category"), price = BigDecimal(10))
        val cart = Cart(cartId)

        `when`(productRepository.findById(productId)).thenReturn(Optional.of(product))
        `when`(cartRepository.findById(cartId)).thenReturn(Optional.of(cart))

        // Act
        cartService.addItem(cartId, productId, amount)

        // Assert
        assertEquals(1, cart.cartItems.size)
        val cartItem = cart.cartItems.first()
        assertEquals(productId, cartItem.product.id)
        assertEquals(productName, cartItem.product.productName)
        assertEquals(productPrice, cartItem.product.price)
        assertEquals(amount, cartItem.amount)
    }
}


