package com.JuMarket.autoatendimento.JuMarket.entity

import java.math.BigDecimal

data class Product(
    val id: Long? = null,
    var name: String,
    var unitOfMeasure: String,
    var price: BigDecimal,

)
