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

    // 🔐 Same structure as screenshot
    private static final String SECRET =
            "sdjhgwbuwbbgwuub08QFQ8qg87G1bfewifbuwg7iu8wefqhjk";

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // ⏰ 1 hour (tests only check > 0)
    private final long EXPIRATION_MILLIS = 60 * 60 * 1000;

    // =================================================
    // REQUIRED BY YOUR TEST CASE
    // =================================================

    // ✔ Test: generateToken(Map<String,Object>, String)
    public String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✔ Test: getUsername(token)
    public String getUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // ✔ Test: isTokenValid(token, username)
    public boolean isTokenValid(String token, String username) {
        String extractedUsername = getUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }

    // ✔ Test: getExpirationMillis() > 0
    public long getExpirationMillis() {
        return EXPIRATION_MILLIS;
    }

    // =================================================
    // HELPER METHODS (SCREENSHOT STYLE)
    // =================================================

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
