package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import java.math.BigDecimal

data class CartDto (
    val id: Long,
    var items: List<Product>,
    var itemCount: Int,
    var totalValue: BigDecimal
){

    fun toEntity(): Cart = Cart(
        id = this.id,
        items = this.items,
        itemCount = this.itemCount,
        totalValue = this.totalValue

    )
}