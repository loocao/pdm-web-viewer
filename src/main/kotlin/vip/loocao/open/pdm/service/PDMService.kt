package vip.loocao.open.pdm.service

import com.smshen.utils.PDM
import com.smshen.utils.PDMTable
import com.smshen.utils.Parser
import org.springframework.stereotype.Service
import vip.loocao.open.pdm.Application
import java.util.*

/**
 * @author loocao
 * @since 2017/10/13
 */
@Service
class PDMService {

    fun getPDM(): PDM? {
        return pdm
    }

    fun getTables(): ArrayList<PDMTable>? {
        return pdm.tables
    }

}

var pdm: PDM = loadTestPDM()!!

fun loadTestPDM(): PDM? {
    val pdmFileInputStream = Application::class.java.getResourceAsStream("/会员卡托管系统.pdm")
    val parser = Parser()
    return parser.pdmParser(pdmFileInputStream)
}