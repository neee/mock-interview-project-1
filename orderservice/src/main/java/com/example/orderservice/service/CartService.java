package com.example.orderservice.service;

import com.example.orderservice.model.Cart;
import com.example.orderservice.util.EmailNotifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartService {

    private Map<String, Cart> carts = new HashMap<>();
    private final EmailNotifier notifier = new EmailNotifier();

    public void createCart(String customer) {
        carts.put(customer, new Cart(customer));
        notifier.sendEmail(customer, "Your cart has been created");
    }

    public void addItem(String customer, String item) {
        Cart cart = carts.get(customer);
        if (cart != null) {
            cart.getItems().add(item);
        }
    }

    public List<String> getItems(String customer) {
        return carts.get(customer).getItems();
    }
}
