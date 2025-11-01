package com.cognatech.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognatech.dto.LoginDTO;
import com.cognatech.dto.RegisterDTO;
import com.cognatech.entity.Users;
import com.cognatech.service.AuthService;
import com.cognatech.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
   
	private final JwtService jwtService;
    private final AuthService authService;

    public AuthController(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Users> register(@RequestBody RegisterDTO registerDTO) {
        Users registeredUser = authService.signup(registerDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginDTO loginDTO) {
        Users authenticatedUser = authService.authenticate(loginDTO);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        return ResponseEntity.ok(jwtToken);
    }
}