package com.JuMarket.autoatendimento.JuMarket.service.impl

import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.entity.Sale
import com.JuMarket.autoatendimento.JuMarket.repository.SaleRepository
import com.JuMarket.autoatendimento.JuMarket.service.ISaleService
import org.springframework.stereotype.Service

@Service
class SaleService(
    private val saleRepository: SaleRepository
): ISaleService {

    override fun save(sale: Sale): Sale =
        this.saleRepository.save(sale)

    override fun findById(id: Long): Sale =
        this.saleRepository.findById(id).orElseThrow {
            throw RuntimeException ("ID $id not found")
    }
}