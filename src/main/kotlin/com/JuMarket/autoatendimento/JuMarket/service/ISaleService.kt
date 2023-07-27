package com.JuMarket.autoatendimento.JuMarket.service

import com.JuMarket.autoatendimento.JuMarket.entity.Product
import com.JuMarket.autoatendimento.JuMarket.entity.Sale

interface ISaleService {

    fun save(sale: Sale): Sale
    fun findById(id: Long): Sale
}