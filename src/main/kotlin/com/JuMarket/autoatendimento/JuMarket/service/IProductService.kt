package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.entity.Product

interface IProductService {
    fun save(product: Product): Product
    fun delete(id: Long)
    fun findById(id: Long): Product

    fun findAll(): List<Product>
}