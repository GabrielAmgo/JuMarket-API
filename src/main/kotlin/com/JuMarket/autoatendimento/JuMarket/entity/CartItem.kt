package com.JuMarket.autoatendimento.JuMarket.entity

import jakarta.persistence.*

@Entity
data class CartItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "Cart_id")
    val cart: Cart,
    @ManyToOne
    @JoinColumn(name = "Product_id")
    val product: Product,
    val amount: Int
)
