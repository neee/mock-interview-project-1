package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.util.EmailNotifier;

import java.util.*;

public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private final EmailNotifier notifier = new EmailNotifier();
    private final Map<String, Double> prices = Map.of("ABC",10.0); // data from manager

    public Order createOrder(String customerName, List<String> items) {
        Order order = new Order(UUID.randomUUID().toString(), customerName, items, calculateTotalPrice(items));
        orders.add(order);
        notifier.sendEmail(customerName, "Order created with ID: " + order.getOrderId());
        saveToDatabase(order);
        return order;
    }

    private synchronized double calculateTotalPrice(List<String> items) {
        double totalPrice = 0;
        for (String item : items) {
            Double price = prices.get(item);
            if (price != null) {
                totalPrice += price;
            } else {
                throw new IllegalArgumentException("Item not found: " + item);
            }
        }
        return totalPrice;
    }

    private void saveToDatabase(Order order) {
        try {
            var conn = java.sql.DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            var stmt = conn.prepareStatement("INSERT INTO orders (id, customer, item_count) VALUES (?, ?, ?)");
            stmt.setString(1, order.getOrderId());
            stmt.setString(2, order.getCustomerName());
            stmt.setInt(3, order.getItems().size());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException("DB error", e);
        }
    }
}
