package br.com.devjr.controller

import br.com.devjr.domain.model.Sale
import br.com.devjr.service.impl.SmsServiceImpl
import br.com.devjr.service.saleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("/sales")
class SaleController(
    private val saleService: saleService,
    private val smsService: SmsServiceImpl
    ) {

    @GetMapping
    fun findSales(@RequestParam(value = "minDate", defaultValue = " ") minDate: String,
                  @RequestParam(value = "maxDate", defaultValue = " ") maxDate: String,
                  pageable: Pageable):Page<Sale>{
        return saleService.findSales(minDate,maxDate,pageable)

    }


    @GetMapping("/{id}/notification")
    fun sendNotify(@PathVariable id: Long){
        smsService.sendSms(id)
    }

}