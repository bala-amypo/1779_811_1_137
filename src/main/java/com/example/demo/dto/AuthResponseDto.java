package com.example.demo.dto;

public class AuthResponseDto {

    private String token;

    // Constructor REQUIRED by your test case
    public AuthResponseDto(String token) {
        this.token = token;
    }

    // Getter REQUIRED by your test case
    public String getToken() {
        return token;
    }
}
