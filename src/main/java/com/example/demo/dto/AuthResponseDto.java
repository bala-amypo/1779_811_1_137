package com.example.demo.dto;

public class AuthResponseDto {
    public String token;
    public String email;

    public AuthResponseDto(String token, String email) {
        this.token = token;
        this.email = email;
    }
}
