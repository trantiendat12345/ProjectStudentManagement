package com.example.student.management.be.security.service.impl;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.student.management.be.configs.JwtConfig;
import com.example.student.management.be.security.service.BaseServiceSecurity;
import com.example.student.management.be.security.service.interfaces.JwtService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl extends BaseServiceSecurity implements JwtService {

    private final JwtConfig jwtConfig;
    private Key key;

    public JwtServiceImpl (JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
        this.key = Keys.hmacShaKeyFor(Base64.getEncoder().encode(jwtConfig.getSecretKey().getBytes()));
    }

    @Override
    public String generateToken (Long accountId, String username, int roleId, String studentCode, String teacherCode) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtConfig.getExpiration());

        Map<String, Object> claims = new HashMap<>();
        claims.put("accountId", accountId);
        claims.put("username", username);
        claims.put("roleId", roleId);
    
        if (studentCode != null) {
            claims.put("studentCode", studentCode);
        }

        if (teacherCode != null) {
            claims.put("teacherCode", teacherCode);
        }
        
        return Jwts.builder()
            .setSubject(username)
            .addClaims(claims)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();
    }
    
}
