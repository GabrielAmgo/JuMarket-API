package com.JuMarket.autoatendimento.JuMarket.service.impl

import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.repository.ProductRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.math.BigDecimal
import java.util.Optional

class ProductServiceTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    @InjectMocks
    private lateinit var productService: ProductService

    private val testProductId = 1
    private val testProductName = "Test Product"
    private val testCategoryId = 1

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `findById should return the correct product`() {
        val expectedProduct = Product(id = testProductId, productName = testProductName, price = BigDecimal(10), measureUnit = "300g", category = Category(testCategoryId, name = "Test Category"))
        `when`(productRepository.findById(testProductId)).thenReturn(Optional.of(expectedProduct))
        val result = productService.findById(testProductId)
        assertEquals(expectedProduct, result)
    }
}

