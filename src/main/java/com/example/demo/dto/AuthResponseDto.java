package com.example.demo.dto;

public class AuthResponseDto {

    private String token;

    // REQUIRED by test: new AuthResponseDto(token)
    public AuthResponseDto(String token) {
        this.token = token;
    }

    // getter ONLY (no setter required by test)
    public String getToken() {
        return token;
    }
}
