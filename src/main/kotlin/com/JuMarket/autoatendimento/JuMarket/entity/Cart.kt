package com.JuMarket.autoatendimento.JuMarket.entity

import java.math.BigDecimal

data class Cart(
    val id: Long? = null,
    var items: List<Product>,
    var itemCount: Int,
    var totalValue: BigDecimal,
)
