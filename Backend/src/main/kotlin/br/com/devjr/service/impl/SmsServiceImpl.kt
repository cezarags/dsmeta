package br.com.devjr.service.impl

import br.com.devjr.repository.SaleRepository
import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service




@Service
class SmsServiceImpl(
    @Value("\${twilio.sid}")
    val twilioSid: String,

    @Value("\${twilio.key}")
    val twilioKey: String,

    @Value("\${twilio.phone.from}")
    val twilioPhoneFrom: String,

    @Value("\${twilio.phone.to}")
    val twilioPhoneTo: String,

   private val  saleRepository: SaleRepository,
    private val log: Logger? = LoggerFactory.getLogger(SmsServiceImpl::class.java)

) {

    fun sendSms(id: Long) {
         Twilio.init(twilioSid, twilioKey)
        log?.info("$twilioSid, $twilioKey")

        val sale = saleRepository.findById(id)

        val id  = "Numero da venda  = ${sale.get().id} \n"
        val name = "Vendedor " + sale.get().sellerName
        val msg = id +  name

            val to: PhoneNumber = PhoneNumber(twilioPhoneTo)
            val from: PhoneNumber = PhoneNumber(twilioPhoneFrom)

            val message = Message.creator(to, from, msg).create()

            println("Sid do sms enviado ${message.sid}")
    }
}