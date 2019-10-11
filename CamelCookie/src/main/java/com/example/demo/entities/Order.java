package com.example.demo.entities;

import org.apache.camel.http.common.cookie.ExchangeCookieHandler;

public class Order extends ExchangeCookieHandler {

    private String productName;

    private int id;

    private int price;

    private boolean bool;


    public boolean getBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }


    public Order(String productName, int id, int price,boolean bool) {
        this.productName = productName;
        this.id = id;
        this.price = price;
        this.bool = bool;


    }

    public Order() {
    }

    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
