package com.JuMarket.autoatendimento.JuMarket.repository


import com.JuMarket.autoatendimento.JuMarket.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Int>{


   
}
