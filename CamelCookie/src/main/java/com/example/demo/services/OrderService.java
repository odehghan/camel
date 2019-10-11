package com.example.demo.services;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.apache.camel.http.common.cookie.ExchangeCookieHandler;
import org.eclipse.jetty.http.HttpCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.entities.*;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.util.List;
import java.util.Map;

@Component("orderService")
public class OrderService {

    @Autowired
    ExchangeCookieHandler exchangeCookieHandler;

    // This method will be invoked for reach GET request to /orders/{id}
    public Order getOrder(@Headers Map headers, @ExchangeProperties Map properties,Exchange exchange){

        exchangeCookieHandler.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        //A test to see if we can get HttpCookie objects
        CookieStore storeCookie = exchangeCookieHandler.getCookieStore(exchange);
        if(storeCookie.getCookies() !=null){
            System.out.println("####################### We are inside cookie store processor #######################");
            storeCookie.getCookies().forEach(c -> System.out.println(c.getName()));
            System.out.println("#######################    #######################");
        }

        System.out.println("******************Headers******************");
        headers.forEach((k,v)-> System.out.println("this is key: "+ k +" *** This is value: "+ v));
        System.out.println("******************      ******************");

        System.out.println("******************Properties******************");
        properties.forEach((k,v)-> System.out.println("this is key: "+ k +" *** This is value: "+ v));
        System.out.println("******************       ******************");

        // Another test to see if we can get HttpCookie objects
        CookieManager cookieManager = (CookieManager) properties.get("CamelCookieHandler");
        if (cookieManager !=null) {
            System.out.println("*********************** We Are In The Cookie Processor ********************** ");
            cookieManager.getCookieStore().getCookies().forEach(c -> System.out.println(c.getName()));
            System.out.println("***********************          ********************** ");
        }

        // This code creates two cookies on the browser
        String[] cookies = {"Key1001=Value1001;Path=/;HttpOnly=true;session-token=test;Expires=Thu, 06-Jan-2022 00:00:00 GMT;",
                "Key1002=Value1002;Path=/;HttpOnly=true;session-token=test;Expires=Thu, 06-Jan-2022 00:00:00 GMT;"};

        // Sets the two cookies on the browser
        headers.put("Set-Cookie",cookies);

        //// This is the object that returns to the browser.
        String idd = (String)headers.get("id");
        int value = Integer.valueOf(idd);
        Order order = new Order("Ipad", value,700,false);
        return order;
    }


}
