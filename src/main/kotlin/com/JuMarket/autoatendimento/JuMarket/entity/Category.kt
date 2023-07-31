package com.JuMarket.autoatendimento.JuMarket.entity

import jakarta.persistence.*

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(nullable = false, unique = true)
    var name: String = "",

)
