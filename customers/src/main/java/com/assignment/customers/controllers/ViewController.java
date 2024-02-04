package com.assignment.customers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/customer-list")
    public String customerList() {
        return "customer-list";
    }

    @GetMapping("/add-customer")
    public String addCustomer() {
        return "add-customer";
    }
}