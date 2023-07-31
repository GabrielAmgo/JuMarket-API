package com.JuMarket.autoatendimento.JuMarket.dto


import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.CartItem
import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import java.math.BigDecimal

data class CartDto (
        val id: Int? = null,
        var cartItems: MutableList<CartItem> = mutableListOf(),
        var totalValue: BigDecimal,
        var paymentMethod: PaymentMethod? = null
){

    fun toEntity(): Cart = Cart(
        id = this.id,
        cartItems = this.cartItems,
        totalValue = this.totalValue,
        paymentMethod = this.paymentMethod

    )
}