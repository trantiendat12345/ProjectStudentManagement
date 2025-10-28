package com.example.student.management.be.security.service.interfaces;

import com.example.student.management.be.request.LoginRequest;

public interface AuthService {

    public Object login(LoginRequest request);
    
}
