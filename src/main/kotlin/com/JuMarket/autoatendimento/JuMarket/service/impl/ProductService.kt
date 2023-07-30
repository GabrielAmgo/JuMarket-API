package com.JuMarket.autoatendimento.JuMarket.service.impl

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.repository.ProductRepository
import com.JuMarket.autoatendimento.JuMarket.service.IProductService
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
): IProductService {
    override fun save(product: Product): Product =
        this.productRepository.save(product)

    override fun delete(id: Long) {
        this.productRepository.deleteById(id)
    }

    override fun findById(id: Long): Product =
        this.productRepository.findById(id).orElseThrow {
            throw RuntimeException ("Id $id not found")
        }

    override fun findAll(): List<Product> =
        this.productRepository.findAll()
}