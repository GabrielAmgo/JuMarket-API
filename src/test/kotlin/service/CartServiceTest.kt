import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.CartItem
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.repository.CartRepository
import com.JuMarket.autoatendimento.JuMarket.repository.CartItemRepository
import com.JuMarket.autoatendimento.JuMarket.repository.ProductRepository
import com.JuMarket.autoatendimento.JuMarket.service.impl.CartService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.MockitoAnnotations.openMocks
import java.math.BigDecimal
import java.util.*

class CartServiceTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    @Mock
    private lateinit var cartRepository: CartRepository

    @Mock
    private lateinit var cartItemRepository: CartItemRepository

    private lateinit var cartService: CartService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        cartService = CartService(productRepository, cartRepository, cartItemRepository, mutableMapOf())
    }

    @Test
    fun `test addItem`() {
        val category = Category(1,"Snack")
        val productId = 1
        val amount = 2
        val product = Product(productId, "Product 1", "500g", category, BigDecimal.valueOf(10.0))
        val cart = Cart()

        `when`(productRepository.findById(productId)).thenReturn(Optional.of(product))
        `when`(cartRepository.save(cart)).thenReturn(cart)

        cartService.addItem(cart.id, productId, amount)

        // Add your assertions here to check if the item is added to the cart as expected
    }

    @Test
    fun `test removeItem`() {
        val category = Category(1, "Snack")
        val productId = 1
        val amount = 1
        val product = Product(productId, "Product 1", "500g", category, BigDecimal.valueOf(10.0))

        val cartItem = CartItem(id = 1L, cart = Cart(id = 1), product = product, amount = 2)
        val cart = Cart(id = 1, cartItems = mutableListOf(cartItem))

        `when`(cartRepository.findById(productId)).thenReturn(Optional.of(cart))

        cartService.removeItem(cart.id, productId, amount)

        // Add your assertions here to check if the item is removed from the cart as expected
    }

}