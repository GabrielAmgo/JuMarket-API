package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.dto.CartItemDto
import com.JuMarket.autoatendimento.JuMarket.dto.CartItemInfoDto
import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import jakarta.persistence.Id

interface ICartService {
    fun save(cart: Cart)
    fun addItem(cartId: Long?, productId: Long, amount: Int)
    fun removeItem(productId: Long,amount: Int)
    fun displayCart() : Pair<Long?, List<CartItemInfoDto>>

    fun findById(id: Long): Cart
    fun clearCart()
}