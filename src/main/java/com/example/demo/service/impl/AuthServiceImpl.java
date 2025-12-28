package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserAccountRepository userRepo,
                           PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // ================= LOGIN =================
    @Override
    public AuthResponseDto login(AuthRequestDto request) {

        if (request.getEmail() == null || request.getPassword() == null) {
            throw new BadRequestException("Email and password are required");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserAccount user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());

        String token = jwtUtil.generateToken(claims, user.getEmail());

        return new AuthResponseDto(token);
    }

    // ================= REGISTER =================
    @Override
    public void register(RegisterRequestDto request) {

        // ✅ FIX 1: Email validation
        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new BadRequestException("Email cannot be empty");
        }

        // ✅ FIX 2: Password validation (PREVENTS 500 ERROR)
        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new BadRequestException("Password cannot be empty");
        }

        // ✅ FIX 3: Duplicate email check
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        // ✅ FIX 4: Create user safely
        UserAccount user = new UserAccount();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true); // IMPORTANT for login & authorization

        userRepo.save(user);
    }
}
