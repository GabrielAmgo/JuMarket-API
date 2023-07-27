package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import java.math.BigDecimal

data class CartView(
    val id: Long?,
    var items: List<Product>,
    var itemCount: Int,
    var totalValue: BigDecimal
) {

constructor(cart: Cart): this(
    id = cart.id,
    items = cart.items,
    itemCount = cart.itemCount,
    totalValue = cart.totalValue
    )

}
