package com.cognatech.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognatech.dto.LoginDTO;
import com.cognatech.dto.RegisterDTO;
import com.cognatech.entity.Users;
import com.cognatech.repository.UserRepository;

@Service
public class AuthService {
	
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(AuthenticationManager authenticationManager,
    		UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users signup(RegisterDTO input) {
        Users user = new Users();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(input.getRole());
        return userRepository.save(user); //insert into users ...
    }

    public Users authenticate(LoginDTO input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(input.getEmail(),input.getPassword())
        );
        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
    
}