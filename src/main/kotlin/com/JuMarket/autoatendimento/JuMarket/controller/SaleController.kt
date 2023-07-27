package com.JuMarket.autoatendimento.JuMarket.controller


import com.JuMarket.autoatendimento.JuMarket.dto.SaleDto
import com.JuMarket.autoatendimento.JuMarket.dto.SaleView
import com.JuMarket.autoatendimento.JuMarket.entity.Sale
import com.JuMarket.autoatendimento.JuMarket.service.impl.SaleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sale")
class SaleController(
    private val saleService: SaleService
) {

    @PostMapping
    fun saveSale (@RequestBody saleDto: SaleDto): String{
        val savedSale = this.saleService.save(saleDto.toEntity())
        return "Sale $savedSale saved!"
}

    @GetMapping("/api/{id}")
    fun findById(@PathVariable id: Long) : SaleView {
        val sale: Sale = this.saleService.findById(id)
        return SaleView(sale)
    }
    }