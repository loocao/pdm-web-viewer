package vip.loocao.open.pdm.web

import com.smshen.utils.Parser
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import vip.loocao.open.pdm.Application

/**
 * @author loocao
 * @since 2017/10/13
 */
@Controller
@RequestMapping("")
class MainController {

    @GetMapping("/")
    fun index(model: Model): String {
        val pdmFileInputStream = Application::class.java.getResourceAsStream("/会员卡托管系统.pdm")
        val parser = Parser()
        val pdm = parser.pdmParser(pdmFileInputStream)

        model.addAttribute("pdm", pdm)

        return "index"
    }
}