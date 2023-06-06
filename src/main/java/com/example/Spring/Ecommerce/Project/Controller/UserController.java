package com.example.Spring.Ecommerce.Project.Controller;


import com.example.Spring.Ecommerce.Project.Dto.CartResponse;
import com.example.Spring.Ecommerce.Project.Model.Product;
import com.example.Spring.Ecommerce.Project.Model.User;
import com.example.Spring.Ecommerce.Project.Service.JwtService;
import com.example.Spring.Ecommerce.Project.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @Autowired
    JwtService jwtService;

    @GetMapping("/check")
    public User check(Principal principal) {
        return (User)userDetailsService.loadUserByUsername(principal.getName());
    }

    @GetMapping("/products")
    public List<Product> getProducts(HttpServletRequest headers) {

        return userService.getProducts();
    }

    @PostMapping("/products/{pid}")
    public CartResponse addToCart(HttpServletRequest headers,@PathVariable("pid") Long proid) {
        String token = headers.getHeader("Authorization").substring(7);
        return userService.addToCart(proid, jwtService.extractUsername(token));
    }

    @GetMapping("/cart-item")
    public ResponseEntity<?> cartItem(HttpServletRequest header) {
        String token = header.getHeader("Authorization").substring(7);
        List<Product> cartProducts = userService.getCartProduct(jwtService.extractUsername(token));
        if(!cartProducts.isEmpty()) {
            return ResponseEntity.ok(cartProducts);
        }
        return new ResponseEntity<>("No product found in your cart", HttpStatus.NOT_FOUND);
    }
}
