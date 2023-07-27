package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Category
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import java.math.BigDecimal

data class CategoryUpdateDto(
    var name: String
) {

    fun toEntity(category: Category) : Category {
        category.name = this.name
        return category
    }

}
