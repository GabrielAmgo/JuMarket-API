package com.JuMarket.autoatendimento.JuMarket.controller


import com.JuMarket.autoatendimento.JuMarket.dto.SaleDto
import com.JuMarket.autoatendimento.JuMarket.dto.SaleView
import com.JuMarket.autoatendimento.JuMarket.entity.Cart
import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.entity.Sale
import com.JuMarket.autoatendimento.JuMarket.enum.PaymentMethod
import com.JuMarket.autoatendimento.JuMarket.service.impl.CartService
import com.JuMarket.autoatendimento.JuMarket.service.impl.SaleService
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/sale")
class SaleController(
        private val cartService: CartService,
        private val saleService: SaleService
) {

    @GetMapping("/{cartId}/totalValue")
    fun calculateTotalValue(@PathVariable cartId: Int): String {
        return saleService.calculateTotalValue(cartId)
    }

    @PostMapping("/paymentMethod")
    fun updatePaymentMethod(@RequestParam cartId: Int, @RequestParam paymentMethod: PaymentMethod): String {
        return saleService.paymentMethod(cartId, paymentMethod)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int) : SaleView {
        val sale: Sale = this.saleService.findById(id)
        return SaleView(sale)
    }

    @GetMapping("/sales")
    fun findAll(): List<Sale>{
        return  saleService.findAll()
    }

    }