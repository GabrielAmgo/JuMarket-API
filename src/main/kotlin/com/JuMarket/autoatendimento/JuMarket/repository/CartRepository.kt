package com.JuMarket.autoatendimento.JuMarket.repository

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


    @Repository
    interface CartRepository : JpaRepository<Cart, Long>
