package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Category

interface ICategoryService {
    fun save(category: Category): Category
    fun delete(id: Int)
    fun findById(id: Int): Category

    fun findAll(): List<Category>
}