package com.JuMarket.autoatendimento.JuMarket.entity

import jakarta.persistence.*
import java.math.BigDecimal
@Entity
data class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, unique = true)
    var paymentMethod: String,
    @Column(nullable = false, unique = true)
    var totalValue: BigDecimal

)
