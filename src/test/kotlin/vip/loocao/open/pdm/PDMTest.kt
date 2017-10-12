package vip.loocao.open.pdm

import com.smshen.utils.Parser
import org.junit.Test

/**
 * @author loocao
 * @since 2017/10/12
 */
class PDMTest {

    /**
     * 测试PDM读取
     */
    @Test
    fun parsePDM() {
        val pdmFileInputStream = PDMTest::class.java.getResourceAsStream("/会员卡托管系统.pdm")
        val parser = Parser()
        val pdm = parser.pdmParser(pdmFileInputStream)
        pdm.tables.stream().forEach {
            println("table-->" + it.getName() + ", code-->" + it.getCode())
        }
    }
}