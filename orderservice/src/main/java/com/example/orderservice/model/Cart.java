package com.example.orderservice.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final String customer;
    private final List<String> items;

    public Cart(String customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public String getCustomer() {
        return customer;
    }

    public List<String> getItems() {
        return items;
    }
}