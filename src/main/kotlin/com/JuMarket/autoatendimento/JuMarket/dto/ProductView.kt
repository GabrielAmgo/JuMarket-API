package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal

class ProductView(
    val id: Int? = null,
    var productName: String,
    var measureUnit: String,
    val category: Category,
    var price: BigDecimal
) {
    constructor(product: Product): this(
        id = product.id,
        productName = product.productName,
        measureUnit = product.measureUnit,
        category = product.category,
        price = product.price
    )
}
