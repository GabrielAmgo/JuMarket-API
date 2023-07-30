package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Sale
import java.math.BigDecimal

data class SaleDto(
    val id: Long? = null,
    val paymentMethod: String,
    val totalValue: BigDecimal
) {
    
    fun toEntity(): Sale = Sale(
        id = this.id,
        paymentMethod = this.paymentMethod,
        totalValue = this.totalValue
    )
}