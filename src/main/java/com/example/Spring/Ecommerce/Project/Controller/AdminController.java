package com.example.Spring.Ecommerce.Project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminController {
    @GetMapping("/login")
    public String loginGet() {
        return "hello welcome";
    }
}