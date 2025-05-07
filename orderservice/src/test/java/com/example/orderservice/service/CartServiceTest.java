package com.example.orderservice.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    @Test
    public void testEmptyCart() {
        CartService service = new CartService();
        service.createCart("Alice");
        assertEquals(0, service.getItems("Alice").size());
    }

    @Test
    public void testNullCartAccess() {
        CartService service = new CartService();
        assertThrows(NullPointerException.class, () -> service.getItems("Bob"));
    }
}