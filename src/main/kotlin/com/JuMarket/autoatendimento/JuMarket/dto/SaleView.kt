package com.JuMarket.autoatendimento.JuMarket.dto


import com.JuMarket.autoatendimento.JuMarket.entity.Sale
import java.math.BigDecimal

class SaleView(
    val id: Long? = null,
    var paymentMethod: String,
    var totalValue: BigDecimal
) {
    constructor(sale: Sale): this(
        id = sale.id,
        paymentMethod = sale.paymentMethod,
        totalValue = sale.totalValue
    )
}
