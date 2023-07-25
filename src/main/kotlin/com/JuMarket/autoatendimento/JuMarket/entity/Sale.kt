package com.JuMarket.autoatendimento.JuMarket.entity

import jakarta.persistence.*
import java.math.BigDecimal
@Entity
data class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToMany
    val carts: List<Cart>,
    @Column(nullable = false, unique = true)
    var paymentMethod: String,
    @Column(nullable = false, unique = true)
    var totalValue: BigDecimal

)
