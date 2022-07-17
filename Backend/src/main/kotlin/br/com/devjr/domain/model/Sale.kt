package br.com.devjr.domain.model

import javax.persistence.Entity

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "tb_sales")
class Sale (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val sellerName: String,
    val visited: Int,
    val deals: Int,
    val amount: BigDecimal,
    val date: LocalDate,
)