package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.entity.Product

interface IProductService {
    fun save(product: Product): Product
    fun delete(id: Int)
    fun findById(id: Int): Product

    fun findAll(): List<Product>
}