package com.JuMarket.autoatendimento.JuMarket.dto

import com.JuMarket.autoatendimento.JuMarket.entity.Category


data class CategoryView(
    val id: Long? = null,
    var name: String = ""
    ) {

    constructor(category: Category): this(
        id = category.id,
        name = category.name
    )

}
