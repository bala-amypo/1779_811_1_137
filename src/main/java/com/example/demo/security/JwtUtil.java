package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET =
            "thisIsASecretKeyForJwtUtilTestCaseOnly123456";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    private static final long EXPIRATION_MILLIS = 60 * 60 * 1000; // 1 hour

    // ===============================
    // Used by SERVICE / TEST CASES
    // ===============================
    public String generateToken(String username) {
        return generateToken(Map.of(), username);
    }

    // ===============================
    // Real JWT Generator
    // ===============================
    public String generateToken(Map<String, Object> claims, String username) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + EXPIRATION_MILLIS)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ===============================
    // Extract username
    // ===============================
    public String getUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // ===============================
    // Validate token
    // ===============================
    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username)
                && extractClaims(token).getExpiration().after(new Date());
    }

    // ===============================
    // Expiry time (used in tests)
    // ===============================
    public long getExpirationMillis() {
        return EXPIRATION_MILLIS;
    }

    // ===============================
    // Internal claims parser
    // ===============================
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
