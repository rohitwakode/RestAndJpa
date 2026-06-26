package com.Lucifer.restApiJpa.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://loacalhost:5173","http://loacalhost:5174")
                .allowedMethods("GET","POST","PUT","DELETE");
    }
}
//addaMapping for mappers ex. GET,POST,DELETE,PUT