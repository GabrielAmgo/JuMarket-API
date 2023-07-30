package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.CartItem
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import java.math.BigDecimal

data class CartUpdateDto(
        var cartItems: MutableList<CartItem> = mutableListOf(),
        var totalValue: BigDecimal
) {

    fun toEntity(cart: Cart) : Cart {
        cart.cartItems = this.cartItems
        cart.totalValue = this.totalValue
        return cart
    }
}
