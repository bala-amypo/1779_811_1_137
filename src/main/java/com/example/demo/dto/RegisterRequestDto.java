package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequestDto {

    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String fullName;

    @NotBlank
    @Size(min = 6)
    public String password;
}
