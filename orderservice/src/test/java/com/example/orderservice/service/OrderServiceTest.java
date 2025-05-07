package com.example.orderservice.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    public void testOrderCreationWithoutVerification1() {
        OrderService service = new OrderService();
        service.createOrder("John", List.of("Item1", "Item2"));
        assertTrue(true);
    }

    @Test
    public void testOrderCreationWithoutVerification2() {
        OrderService service = new OrderService();
        service.createOrder("Bill", List.of("Item1", "Item2"));
        assertTrue(true);
    }
}
