package vip.loocao.open.pdm.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * @author loocao
 * @since 2017/10/13
 */
@Configuration
class WebMvcConfiguration : WebMvcConfigurerAdapter() {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("*");
    }

}