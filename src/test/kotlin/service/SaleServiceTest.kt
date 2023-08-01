import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.CartItem
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import com.JuMarket.autoatendimento.JuMarket.repository.SaleRepository
import com.JuMarket.autoatendimento.JuMarket.service.impl.CartService
import com.JuMarket.autoatendimento.JuMarket.service.impl.SaleService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.math.BigDecimal
import java.util.*

class SaleServiceTest {

    @Mock
    private lateinit var saleRepository: SaleRepository

    @Mock
    private lateinit var cartService: CartService

    @InjectMocks
    private lateinit var saleService: SaleService
    private val testCategoryId = 1
    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test calculateTotalValue`() {

        val cartId = 1
        val productId1 = 1
        val amount1 = 2
        val product1 = Product(id = productId1, productName = "Product 1", price = BigDecimal(10), measureUnit = "300g", category = Category(testCategoryId, name = "Test Category"))
        val productId2 = 2
        val amount2 = 3
        val product2 = Product(productId2, "Product 2", price = BigDecimal(11), measureUnit = "300g", category = Category(testCategoryId, name = "Test Category"))

        val cart = Cart(id = cartId, cartItems = mutableListOf(
                CartItem(id = 1, cart = Cart(id = 1), product = product1, amount1),
                CartItem(id = 1, cart = Cart(id = 1), product = product2, amount2)
        ))

        `when`(cartService.findById(cartId)).thenReturn(cart)

        val expectedTotalValue = "Your cart total value is R$${BigDecimal.valueOf(2 * 25 + 3)}"

        val totalValue = saleService.calculateTotalValue(cartId)

        assertEquals(expectedTotalValue, totalValue)
    }

    @Test
    fun `test paymentMethod`() {

        val cartId = 1
        val paymentMethod = PaymentMethod.CREDIT_CARD

        val cart = Cart(id = cartId)

        `when`(cartService.findById(cartId)).thenReturn(cart)
        `when`(cartService.save(cart)).thenReturn(cart)

        val resultMessage = saleService.paymentMethod(cartId, paymentMethod)

        val expectedMessage = "Thank you for buying with us! Your cart $cartId has been paid with $paymentMethod!"
        assertEquals(expectedMessage, resultMessage)
        assertEquals(paymentMethod, cart.paymentMethod)
    }

}
