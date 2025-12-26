package com.example.demo.security;

import java.util.*;

public class JwtUtil {

    private final long expirationMillis = 3600000;

    public String generateToken(Map<String, Object> claims, String subject) {
        return subject + "-token";
    }

    public String getUsername(String token) {
        return token.replace("-token", "");
    }

    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username);
    }

    public long getExpirationMillis() {
        return expirationMillis;
    }
}
