package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import java.math.BigDecimal

data class CartUpdateDto(
    var items: List<Product>,
    var itemCount: Int,
    var totalValue: BigDecimal
) {

    fun toEntity(cart: Cart) : Cart {
        cart.items = this.items
        cart.itemCount = this.itemCount
        cart.totalValue = this.totalValue
        return cart
    }
}
