package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.entity.Sale
import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import java.math.BigDecimal

interface ISaleService {

    fun calculateTotalValue(cartId: Int): String
    fun paymentMethod (cartId: Int, paymentMethod: PaymentMethod): String
    fun findById(id: Int): Sale
    fun findAll(): List<Sale>
}