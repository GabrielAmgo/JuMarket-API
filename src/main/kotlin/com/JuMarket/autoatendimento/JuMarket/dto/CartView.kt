package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.CartItem
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import java.math.BigDecimal

data class CartView(
        val id: Int? = null,
        var cartItems: MutableList<CartItem> = mutableListOf(),
        var totalValue: BigDecimal?,
        var paymentMethod: PaymentMethod? = null
) {

constructor(cart: Cart): this(
    id = cart.id,
    cartItems = cart.cartItems,
    totalValue = cart.totalValue,
    paymentMethod = cart.paymentMethod
    )

}
