package com.JuMarket.autoatendimento.JuMarket.controller

import com.JuMarket.autoatendimento.JuMarket.dto.CartDto
import com.JuMarket.autoatendimento.JuMarket.dto.CartUpdateDto
import com.JuMarket.autoatendimento.JuMarket.dto.CartView
import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.service.impl.CartService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cart")
class CartController(
    private val cartService: CartService
) {

    @PostMapping
    fun saveCart(@RequestBody cartDto: CartDto): String {
        val savedCart = this.cartService.save(cartDto.toEntity())
        return "Cart ${savedCart.id} saved!"
    }

    @GetMapping("/api/{id}")
    fun findById(@PathVariable id: Long) : CartView {
        val cart: Cart = this.cartService.findById(id)
        return CartView(cart)
    }

    @DeleteMapping("/api/{id}")
    fun deleteCart(@PathVariable id: Long) =
        this.cartService.delete(id)

    @PatchMapping
    fun updateCart(@RequestParam(value = "customerId")id: Long,
                   @RequestBody cartUpdateDto: CartUpdateDto
    ):CartView{
        val cart: Cart = this.cartService.findById(id)
        val cartToUpdate: Cart = cartUpdateDto.toEntity(cart)
        val cartUpdated: Cart = this.cartService.save(cartToUpdate)
        return CartView(cartUpdated)
    }

}