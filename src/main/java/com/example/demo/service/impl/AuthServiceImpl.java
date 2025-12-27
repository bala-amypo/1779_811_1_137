package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponseDto register(RegisterRequestDto dto) {
        // registration logic (save user, encode password, etc.)
        return new AuthResponseDto("User registered successfully");
    }

    @Override
    public AuthResponseDto login(AuthRequestDto dto) {
        // authentication + JWT logic
        return new AuthResponseDto("JWT_TOKEN_SAMPLE");
    }
}
