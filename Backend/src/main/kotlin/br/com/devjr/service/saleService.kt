package br.com.devjr.service

import br.com.devjr.domain.model.Sale
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


interface saleService {

    fun findSales(minDate: String, maxDate: String, pageable: Pageable): Page<Sale>
}