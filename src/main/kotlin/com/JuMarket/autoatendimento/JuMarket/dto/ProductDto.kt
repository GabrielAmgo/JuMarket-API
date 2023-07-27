package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import java.math.BigDecimal

data class ProductDto(
    val id: Long,
    var productName: String,
    var measureUnit: String,
    val category: Category,
    var price: BigDecimal
) {

    fun toEntity(): Product = Product(
        id = this.id,
        productName = this.productName,
        measureUnit = this.measureUnit,
        category = this.category,
        price = this.price
    )
}