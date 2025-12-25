package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwt;

    public AuthServiceImpl(UserAccountRepository repo,
                           PasswordEncoder encoder,
                           JwtUtil jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto r) {
        if (repo.existsByEmail(r.email))
            throw new BadRequestException("Email already exists");

        UserAccount u = new UserAccount();
        u.setEmail(r.email);
        u.setFullName(r.fullName);
        u.setPassword(encoder.encode(r.password));
        repo.save(u);

        return new AuthResponseDto(jwt.generateToken(r.email), r.email);
    }

    @Override
    public AuthResponseDto login(AuthRequestDto r) {
        UserAccount u = repo.findByEmail(r.email)
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!encoder.matches(r.password, u.getPassword()))
            throw new BadRequestException("Invalid credentials");

        return new AuthResponseDto(jwt.generateToken(r.email), r.email);
    }
}
