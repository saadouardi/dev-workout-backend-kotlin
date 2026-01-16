package com.micromerce.workout.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig {

    private fun allowedOrigins(): Array<String> {
        val env = System.getenv("CORS_ALLOWED_ORIGINS") ?: "http://localhost:5173"
        return env.split(",").map { it.trim() }.filter { it.isNotEmpty() }.toTypedArray()
    }

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        val origins = allowedOrigins()

        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedOrigins(*origins)
                    .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
            }
        }
    }
}
