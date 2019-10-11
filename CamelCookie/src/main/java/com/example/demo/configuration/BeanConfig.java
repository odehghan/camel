package com.example.demo.configuration;

import org.apache.camel.http.common.cookie.ExchangeCookieHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.CookiePolicy;


@Configuration
public class BeanConfig {


    @Bean("exchangeCookieHandler")
    public ExchangeCookieHandler exchangeCookieHandler(){

        ExchangeCookieHandler exchangeCookieHandler = new ExchangeCookieHandler();
        exchangeCookieHandler.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        return exchangeCookieHandler;
    }


}
