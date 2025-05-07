package com.example.orderservice.model;

import java.util.List;

public class Order {

    private final String orderId;
    private final String customerName;
    private final List<String> items;
    private final double totalPrice;

    public Order(String orderId, String customerName, List<String> items, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}