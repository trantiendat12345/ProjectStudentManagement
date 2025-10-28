package com.example.student.management.be.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expirationTime;

    public Long getExpiration() {
        return expirationTime;
    }

    public String getSecretKey() {
        return secretKey;
    }
    
}
