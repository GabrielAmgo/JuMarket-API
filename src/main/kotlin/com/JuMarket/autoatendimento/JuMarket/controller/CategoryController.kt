package com.JuMarket.autoatendimento.JuMarket.controller

import com.JuMarket.autoatendimento.JuMarket.dto.*
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.service.impl.CategoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController(
    private val categoryService: CategoryService
) {

    @PostMapping
    fun saveCategory(@RequestBody categoryDto: CategoryDto): String {
        val savedCategory = this.categoryService.save(categoryDto.toEntity())
        return "Category $savedCategory saved!"
    }

    @GetMapping("/api/{id}")
    fun findById(@PathVariable id: Long) : CategoryView {
        val category: Category = this.categoryService.findById(id)
        return CategoryView(category)
    }

    @DeleteMapping("/api/{id}")
    fun deleteCategory(@PathVariable id: Long) =
        this.categoryService.delete(id)

    @PatchMapping
    fun updateCategory(@RequestParam(value = "categoryId")id: Long,
                       @RequestBody categoryUpdateDto: CategoryUpdateDto
    ): CategoryView{
        val category: Category = this.categoryService.findById(id)
        val categoryToUpdate: Category = categoryUpdateDto.toEntity(category)
        val categoryUpdated: Category = this.categoryService.save(categoryToUpdate)
        return CategoryView(categoryUpdated)
    }
}