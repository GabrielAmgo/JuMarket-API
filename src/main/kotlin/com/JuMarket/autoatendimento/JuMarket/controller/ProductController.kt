package com.JuMarket.autoatendimento.JuMarket.controller

import com.JuMarket.autoatendimento.JuMarket.dto.*
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.service.impl.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun saveProduct (@RequestBody productDto: ProductDto): String{
        val savedProduct = this.productService.save(productDto.toEntity())
        return "Product ${savedProduct.productName} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ProductView {
        val product: Product = this.productService.findById(id)
        return ProductView(product)
    }

    @GetMapping("/products")
    fun findAll(): List<Product>{
        return  productService.findAll()
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long) =
        this.productService.delete(id)

    @PatchMapping
    fun updateProduct(@RequestParam(value = "productId")id: Long,
                      @RequestBody productUpdateDto: ProductUpdateDto
    ): ProductView{
        val product: Product = this.productService.findById(id)
        val productToUpdate: Product = productUpdateDto.toEntity(product)
        val productUpdated: Product = this.productService.save(productToUpdate)
        return ProductView(productUpdated)
    }
}