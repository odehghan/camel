package com.example.demo;

import com.example.demo.entities.Order;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class Route extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration().component("jetty").host("localhost").port(9090)
                .endpointProperty("cookieHandler","#exchangeCookieHandler")
                .bindingMode(RestBindingMode.json)
                .apiContextPath("/api-doc")
                .dataFormatProperty("prettyPrint","true");

        rest("/orders")

                .get("{id}").outType(Order.class)
                .to("bean:orderService?method=getOrder")

                .post().outType(Order.class)
                .to("bean:orderService?method=createOrder");
    }
}
