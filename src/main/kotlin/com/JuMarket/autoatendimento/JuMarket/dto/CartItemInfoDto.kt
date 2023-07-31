package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import java.math.BigDecimal

data class CartItemInfoDto(
        val productId: Int,
        val productName: String,
        var amount: Int,
        val unitPrice: BigDecimal,
        val amountPrice: BigDecimal,
)
