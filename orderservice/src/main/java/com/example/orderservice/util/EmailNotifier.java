package com.example.orderservice.util;

public class EmailNotifier {

    public void sendEmail(String to, String body) {
        System.out.println("Sending email to " + to + ": " + body);
    }
}