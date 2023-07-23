package com.JuMarket.autoatendimento.JuMarket.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToMany
    var items: List<Product>,
    @Column(nullable = false, unique = true)
    var itemCount: Int,
    @Column(nullable = false, unique = true)
    var totalValue: BigDecimal,
)
