package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthRequestDto {
    @NotBlank
    public String email;

    @NotBlank
    public String password;
}
