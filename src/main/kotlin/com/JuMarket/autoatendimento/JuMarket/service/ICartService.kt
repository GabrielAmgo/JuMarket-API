package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.dto.CartItemInfoDto
import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import jakarta.persistence.Id

interface ICartService {
    fun save(cart: Cart): Cart
    fun addItem(cartId: Int?, productId: Int, amount: Int)
    fun removeItem(cartId: Int?, productId: Int, amount: Int)
    fun displayCart() : Pair<Int?, List<CartItemInfoDto>>

    fun findById(id: Int): Cart
    fun clearCart()
}