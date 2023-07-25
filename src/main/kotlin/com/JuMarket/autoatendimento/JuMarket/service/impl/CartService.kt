package com.JuMarket.autoatendimento.JuMarket.service.impl

import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.repository.CartRepository
import com.JuMarket.autoatendimento.JuMarket.service.ICartService
import org.springframework.stereotype.Service

@Service
class CartService(
    private val cartRepository: CartRepository
): ICartService {
    override fun save(cart: Cart): Cart =
        this.cartRepository.save(cart)

    override fun delete(id: Long) {
        this.cartRepository.deleteById(id)
    }

    override fun findById(id: Long): Cart =
        this.cartRepository.findById(id).orElseThrow{
            throw RuntimeException ("Id $id not found")
        }

    override fun findAll(cart: Cart): List<Cart> =
        this.cartRepository.findAll()

}