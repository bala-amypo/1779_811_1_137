package com.example.demo.service;

import com.example.demo.dto.*;

public interface AuthService {
    AuthResponseDto login(AuthRequestDto request);
    void register(RegisterRequestDto request);
}
