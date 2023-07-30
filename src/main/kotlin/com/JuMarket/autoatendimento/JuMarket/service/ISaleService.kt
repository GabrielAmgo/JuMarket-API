package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.entity.Sale
import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import java.math.BigDecimal

interface ISaleService {

    fun calculateTotalValue(cartId: Long): BigDecimal
    fun paymentMethod (cartId: Long, paymentMethod: PaymentMethod): String
    fun findById(id: Long): Sale
    fun findAll(): List<Sale>
}