package com.JuMarket.autoatendimento.JuMarket.entity

import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @OneToMany(mappedBy = "cart", cascade = [CascadeType.ALL], orphanRemoval = true)
    var cartItems: MutableList<CartItem> = mutableListOf(),
    @Column(nullable = true)
    var totalValue: BigDecimal? = null,
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    var paymentMethod: PaymentMethod? = null
)

