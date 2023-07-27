package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import java.math.BigDecimal

class ProductUpdateDto(
    var productName: String,
    var measureUnit: String,
    var category: Category,
    var price: BigDecimal
) {

    fun toEntity(product: Product) : Product {
        product.productName = this.productName
        product.measureUnit = this.measureUnit
        product.category = this.category
        product.price = this.price
        return product
    }
}
