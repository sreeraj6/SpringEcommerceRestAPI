package com.example.Spring.Ecommerce.Project.Controller;


import com.example.Spring.Ecommerce.Project.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;
    @GetMapping("/check")
    public User check(Principal principal) {
        return (User)userDetailsService.loadUserByUsername(principal.getName());
    }



}
