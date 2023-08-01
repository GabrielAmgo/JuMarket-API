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

        val categoryId = 1
        val categoryName = "Snack"
        val category = Category(id = categoryId, name = categoryName)

        `when`(categoryRepository.save(category)).thenReturn(category)

        val savedCategory = categoryService.save(category)

        assertEquals(category, savedCategory)
    }

    @Test
    fun `test delete`() {

        val categoryId = 1

        categoryService.delete(categoryId)

    }

    @Test
    fun `test findById`() {

        val categoryId = 1
        val categoryName = "Snack"
        val category = Category(id = categoryId, name = categoryName)

        `when`(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category))

        val foundCategory = categoryService.findById(categoryId)


        assertEquals(category, foundCategory)
    }

    @Test
    fun `test findById with invalid id`() {

        val invalidCategoryId = 99

        `when`(categoryRepository.findById(invalidCategoryId)).thenReturn(Optional.empty())

        assertThrows<RuntimeException> {
            categoryService.findById(invalidCategoryId)
        }
    }

    @Test
    fun `test findAll`() {

        val categoryId1 = 1
        val categoryName1 = "Snack"
        val category1 = Category(id = categoryId1, name = categoryName1)

        val categoryId2 = 2
        val categoryName2 = "Beverage"
        val category2 = Category(id = categoryId2, name = categoryName2)

        val categories = listOf(category1, category2)

        `when`(categoryRepository.findAll()).thenReturn(categories)

        val allCategories = categoryService.findAll()

        assertEquals(categories, allCategories)
    }

}
