import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.repository.CategoryRepository
import com.JuMarket.autoatendimento.JuMarket.service.impl.CategoryService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify // Import necessário
import org.mockito.MockitoAnnotations
import java.util.*

class CategoryServiceTest {

    @Mock
    private lateinit var categoryRepository: CategoryRepository

    @InjectMocks
    private lateinit var categoryService: CategoryService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test save`() {
        // Create some sample data for testing
        val categoryId = 1
        val categoryName = "Snack"
        val category = Category(id = categoryId, name = categoryName)

        // Mock the save method of categoryRepository to return the sample category
        `when`(categoryRepository.save(category)).thenReturn(category)

        // Call the function to be tested
        val savedCategory = categoryService.save(category)

        // Assertions
        assertEquals(category, savedCategory)
    }

    @Test
    fun `test delete`() {
        // Create some sample data for testing
        val categoryId = 1

        // Call the function to be tested
        categoryService.delete(categoryId)

    }

    @Test
    fun `test findById`() {
        // Create some sample data for testing
        val categoryId = 1
        val categoryName = "Snack"
        val category = Category(id = categoryId, name = categoryName)

        // Mock the findById method of categoryRepository to return the sample category
        `when`(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category))

        // Call the function to be tested
        val foundCategory = categoryService.findById(categoryId)

        // Assertions
        assertEquals(category, foundCategory)
    }

    @Test
    fun `test findById with invalid id`() {
        // Create some sample data for testing
        val invalidCategoryId = 99

        // Mock the findById method of categoryRepository to return an empty optional
        `when`(categoryRepository.findById(invalidCategoryId)).thenReturn(Optional.empty())

        // Call the function to be tested and expect an exception to be thrown
        assertThrows<RuntimeException> {
            categoryService.findById(invalidCategoryId)
        }
    }

    @Test
    fun `test findAll`() {
        // Create some sample data for testing
        val categoryId1 = 1
        val categoryName1 = "Snack"
        val category1 = Category(id = categoryId1, name = categoryName1)

        val categoryId2 = 2
        val categoryName2 = "Beverage"
        val category2 = Category(id = categoryId2, name = categoryName2)

        val categories = listOf(category1, category2)

        // Mock the findAll method of categoryRepository to return the sample categories
        `when`(categoryRepository.findAll()).thenReturn(categories)

        // Call the function to be tested
        val allCategories = categoryService.findAll()

        // Assertions
        assertEquals(categories, allCategories)
    }

    // Add more test cases for other functions if necessary
}
