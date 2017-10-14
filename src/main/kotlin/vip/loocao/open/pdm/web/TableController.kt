package vip.loocao.open.pdm.web

import com.smshen.utils.PDM
import com.smshen.utils.PDMColumn
import com.smshen.utils.PDMTable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.loocao.open.pdm.service.PDMService
import java.util.*

/**
 * @author loocao
 * @since 2017/10/13
 */
@RestController
@RequestMapping("/table")
class TableController {

    @Autowired
    constructor(pdmService: PDMService) {
        this.pdmService = pdmService
    }

    private val pdmService: PDMService

    @PostMapping("/list")
    fun list(): ArrayList<PDMTable>? {
        return pdmService.getTables()
    }

    @PostMapping("/{code:.+}/columns")
    fun tableRows(@PathVariable("code") code: String): ArrayList<PDMColumn>? {
        val pdm: PDM = pdmService.getPDM()!!
        val pdmTable = pdm.tables.filter { it.code.equals(code) }[0]
        return pdmTable.columns
    }
}