package com.example.Spring.Ecommerce.Project.Service;

import com.example.Spring.Ecommerce.Project.Dto.AuthenticationResponse;
import com.example.Spring.Ecommerce.Project.Dto.LoginRequest;
import com.example.Spring.Ecommerce.Project.Dto.RegisterRequest;
import com.example.Spring.Ecommerce.Project.Model.Role;
import com.example.Spring.Ecommerce.Project.Model.User;
import com.example.Spring.Ecommerce.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            return null;
        }
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElse(null);
        var jwtToken = jwtService.generateToken((user));
        return new AuthenticationResponse(jwtToken);
    }
}
