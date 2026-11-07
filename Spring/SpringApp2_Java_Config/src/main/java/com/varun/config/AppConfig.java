package com.varun.config;


import com.varun.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(scopeName = "prototype")
    public Desktop desktop(){
        return new Desktop();
    }
}
