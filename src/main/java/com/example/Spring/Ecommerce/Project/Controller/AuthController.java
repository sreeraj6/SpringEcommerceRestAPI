package com.example.Spring.Ecommerce.Project.Controller;

import com.example.Spring.Ecommerce.Project.Dto.AuthenticationResponse;
import com.example.Spring.Ecommerce.Project.Dto.LoginRequest;
import com.example.Spring.Ecommerce.Project.Dto.RegisterRequest;
import com.example.Spring.Ecommerce.Project.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        AuthenticationResponse response = authenticationService.register(request);
        if(response == null) {
            return new ResponseEntity<>("Email exist", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
