package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import java.math.BigDecimal

data class CartItemDto(
        var cartId: Int,
        var productId: Int,
        var amount: Int,
)

