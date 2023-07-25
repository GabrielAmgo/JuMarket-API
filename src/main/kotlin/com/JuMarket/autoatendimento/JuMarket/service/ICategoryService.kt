package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Category

interface ICategoryService {
    fun save(category: Category): Category
    fun delete(id: Long)
    fun findById(id: Long): Category

    fun findAll(category: Category): List<Category>
}