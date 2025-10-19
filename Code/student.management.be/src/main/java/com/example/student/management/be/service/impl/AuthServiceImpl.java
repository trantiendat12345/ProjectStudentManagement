package com.example.student.management.be.service.impl;

import org.springframework.stereotype.Service;

import com.example.student.management.be.request.LoginRequest;
import com.example.student.management.be.resource.LoginResource;
import com.example.student.management.be.response.LoginResponse;
import com.example.student.management.be.service.BaseService;
import com.example.student.management.be.service.interfaces.AuthService;

@Service
public class AuthServiceImpl extends BaseService implements AuthService {

    @Override
    public LoginResponse login(LoginRequest request) {

        try {

            String token = "12334512312313213";
            LoginResource student = new LoginResource(1L, "user01@gmail.com", "Dat", "12345");

            return new LoginResponse(token, student);
            
        } catch (Exception e) {
            throw new RuntimeException("Error when login: " + e.getMessage());
        }
        
    }
    
}
