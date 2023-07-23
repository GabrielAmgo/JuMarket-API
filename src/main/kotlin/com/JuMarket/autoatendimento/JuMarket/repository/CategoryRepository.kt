package com.JuMarket.autoatendimento.JuMarket.repository

import com.JuMarket.autoatendimento.JuMarket.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>
