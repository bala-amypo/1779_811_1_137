package com.example.demo.service.impl;

import com.example.demo.dto.AuthResponseDto;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repo;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserAccountRepository repo, JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponseDto login(String username, String password) {

        UserAccount user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(username);

        AuthResponseDto response = new AuthResponseDto();
        response.setToken(token);
        return response;
    }
}
