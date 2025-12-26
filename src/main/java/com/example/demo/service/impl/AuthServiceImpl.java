package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserAccountRepository repo,
                           PasswordEncoder encoder,
                           AuthenticationManager authManager,
                           JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponseDto login(AuthRequestDto request) {
        UserAccount user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid login"));

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());

        String token = jwtUtil.generateToken(claims, user.getEmail());
        return new AuthResponseDto(token);
    }

    @Override
    public void register(RegisterRequestDto request) {
        if (repo.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
    }
}
