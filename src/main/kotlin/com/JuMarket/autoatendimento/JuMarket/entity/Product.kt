package com.JuMarket.autoatendimento.JuMarket.entity

import jakarta.persistence.*
import java.math.BigDecimal
@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, unique = true)
    var productName: String,
    @Column(nullable = false, unique = true)
    var measureUnit: String,
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category,
    @Column(nullable = false, unique = true)
    var price: BigDecimal,
    @ManyToMany
    var carts: List<Cart>,



)
