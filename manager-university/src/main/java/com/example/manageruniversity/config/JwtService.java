package com.example.manageruniversity.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.function.Function;

@Service
public class JwtService {
    
    private final String SECRET_KEY = "nguyenquangphu";
    public String extractUsername(String token) {
        return null;
    }

    public <T> T extractClaims(String token, Function<String, T> c) {
        return c.apply(token);
    }

    private Claims extractClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

}
