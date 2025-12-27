package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    // ✅ MUST stay long (tests depend on this)
    private final long expirationMillis = 1000 * 60 * 60; // 1 hour

    private final SecretKey key =
            Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // =========================
    // TOKEN CREATION
    // =========================
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + expirationMillis)
                )
                .signWith(key)
                .compact();
    }

    // =========================
    // TOKEN READ
    // =========================
    public String getUsername(String token) {
        return getAllClaims(token).getSubject();
    }

    // =========================
    // TOKEN VALIDATION
    // =========================
    public boolean isTokenValid(String token, String username) {
        return username.equals(getUsername(token))
                && !isTokenExpired(token);
    }

    // =========================
    // ✅ REQUIRED BY TESTS
    // =========================
    public long getExpirationMillis() {
        return expirationMillis;
    }

    // =========================
    // INTERNAL HELPERS
    // =========================
    private boolean isTokenExpired(String token) {
        return getAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
