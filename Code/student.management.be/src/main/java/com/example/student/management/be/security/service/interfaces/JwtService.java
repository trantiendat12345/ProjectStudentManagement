package com.example.student.management.be.security.service.interfaces;

public interface JwtService {
    
    String generateToken (Long accountId, String username, int roleId, String studentCode, String teacherCode);
    
}
