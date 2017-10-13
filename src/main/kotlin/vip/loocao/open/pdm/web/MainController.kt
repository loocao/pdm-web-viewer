package vip.loocao.open.pdm.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author loocao
 * @since 2017/10/13
 */
@Controller
@RequestMapping("")
class MainController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}