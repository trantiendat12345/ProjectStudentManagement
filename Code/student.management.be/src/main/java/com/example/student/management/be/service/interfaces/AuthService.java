package com.example.student.management.be.service.interfaces;

import com.example.student.management.be.request.LoginRequest;
import com.example.student.management.be.response.LoginResponse;

public interface AuthService {

    public LoginResponse login(LoginRequest request);
    
}
