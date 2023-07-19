package com.JuMarket.autoatendimento.JuMarket.entity

import java.math.BigDecimal

data class Sale(
    val id: Long? = null,
    val carts: List<Cart>,
    var paymentMethod: String,
    var totalValue: BigDecimal

)
