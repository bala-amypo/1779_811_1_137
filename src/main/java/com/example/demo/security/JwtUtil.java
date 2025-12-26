package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;   // ✅ ADD THIS

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component   // 🔴 THIS IS THE KEY FIX
public class JwtUtil {

    private static final String SECRET =
            "sdjhgwbuwbbgwuub08QFQ8qg87G1bfewifbuwg7iu8wefqhjk";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    private final long EXPIRATION_MILLIS = 60 * 60 * 1000;

    public String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username)
                && !extractClaims(token).getExpiration().before(new Date());
    }

    public long getExpirationMillis() {
        return EXPIRATION_MILLIS;
    }

    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
