package br.com.devjr.repository

import br.com.devjr.domain.model.Sale
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate

interface SaleRepository : JpaRepository<Sale, Long> {

    @Query("SELECT obj FROM tb_sales obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
    fun findSales(min: LocalDate, max: LocalDate, pageable: Pageable): Page<Sale>
}