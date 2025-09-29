package com.example.student.management.be.service.impl;

import org.springframework.stereotype.Service;

import com.example.student.management.be.request.LoginRequest;
import com.example.student.management.be.resource.StudentResource;
import com.example.student.management.be.response.LoginResponse;
import com.example.student.management.be.service.BaseService;
import com.example.student.management.be.service.interfaces.AuthService;

@Service
public class AuthServiceImpl extends BaseService implements AuthService {

    @Override
    public LoginResponse login(LoginRequest request) {

        try {

            String token = "12334512312313213";
            StudentResource student = new StudentResource(1L, "user01@gmail.com", "123213", null);

            return new LoginResponse(token, student);
            
        } catch (Exception e) {
            throw new RuntimeException("Error when login: " + e.getMessage());
        }
        
    }
    
}
