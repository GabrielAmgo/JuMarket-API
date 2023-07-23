package com.JuMarket.autoatendimento.JuMarket.repository


import com.JuMarket.autoatendimento.JuMarket.entity.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository : JpaRepository<Sale, Long>
