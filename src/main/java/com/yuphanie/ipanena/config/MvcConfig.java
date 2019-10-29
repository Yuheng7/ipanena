package com.yuphanie.ipanena.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000", "http://localhost:8080")
                .allowedMethods("PUT", "DELETE")
                .allowedHeaders("Access-Control-Allow-Origin: http://localhost:8080, http://localhost:3000",
                        "Access-Control-Allow-Methods: GET, POST, PATCH, PUT, DELETE, OPTIONS",
                        "Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token",
                        "Access-Control-Request-Header: Origin, Content-Type, X-Auth-Token",
                        "Access-Control-Request-Method: POST");
            }
        };
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//    }

    public void addResourceHandlers(
            ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/view/react/build/static/");
        registry.addResourceHandler("/*.js")
                .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.json")
                .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/*.ico")
                .addResourceLocations("/WEB-INF/view/react/build/");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("/WEB-INF/view/react/build/index.html");
    }
//
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000", "http://localhost:8080");
////    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//        registry.addMapping("/api/**")
//                .allowedOrigins("http://localhost:3000", "http://localhost:8080")
//                .allowedMethods("PUT", "DELETE")
//                .allowedHeaders("Access-Control-Allow-Origin: *",
//                        "Access-Control-Allow-Methods: GET, POST, PATCH, PUT, DELETE, OPTIONS",
//                        "Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token");
////                .exposedHeaders("header1", "header2")
////                .allowCredentials(false).maxAge(3600);
//    }

//    'Access-Control-Allow-Origin':'*',
//            'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
//            'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
}
