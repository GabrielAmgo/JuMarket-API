package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Category

data class CategoryDto(
    val id: Long,
    var name: String
) {

    fun toEntity(): Category = Category(
        id = this.id,
        name= this.name
    )
}