package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET =
            "sdjhgwbuwbbgwuub08QFQ8qg87G1bfewifbuwg7iu8wefqhjk";

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

    private final long EXPIRATION_MILLIS = 60 * 60 * 1000; // 1 hour

    // REQUIRED BY TEST
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

    // REQUIRED BY TEST
    public String getUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // REQUIRED BY TEST
    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username) && !isTokenExpired(token);
    }

    // REQUIRED BY TEST
    public long getExpirationMillis() {
        return EXPIRATION_MILLIS;
    }

    // helpers
    private boolean isTokenExpired(String token) {
        return extractClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
