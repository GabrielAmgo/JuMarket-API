package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.entity.Cart

interface ICartService {
    fun save(cart: Cart): Cart
    fun delete(id: Long)
    fun findById(id: Long):Cart
    fun findAll(cart: Cart): List<Cart>
}