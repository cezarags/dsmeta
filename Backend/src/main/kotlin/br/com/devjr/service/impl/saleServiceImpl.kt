package br.com.devjr.service.impl
import br.com.devjr.domain.model.Sale
import br.com.devjr.repository.SaleRepository
import br.com.devjr.service.saleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class saleServiceImp(
    private val saleRepository: SaleRepository
): saleService{

    override fun findSales(minDate: String, maxDate: String, pageable: Pageable): Page<Sale> {

        var min: LocalDate = LocalDate.now()
        var max: LocalDate = LocalDate.now()

        when (minDate.equals(" ") && maxDate.equals(" ")) {
            true -> min = LocalDate.now().minusDays(365)
            true -> max = LocalDate.now()
            false -> min = LocalDate.parse(minDate)
            false -> max = LocalDate.parse(maxDate)
            // else -> LocalDate.now()// TODO adicionar um exception customizada.

        }

        return saleRepository.findSales(min, max, pageable)
    }
}