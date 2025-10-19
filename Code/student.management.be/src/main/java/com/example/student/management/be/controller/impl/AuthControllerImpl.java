package com.example.student.management.be.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.student.management.be.controller.BaseController;
import com.example.student.management.be.controller.interfaces.AuthController;
import com.example.student.management.be.request.LoginRequest;
import com.example.student.management.be.response.LoginResponse;
import com.example.student.management.be.service.interfaces.AuthService;

@Component
public class AuthControllerImpl extends BaseController implements AuthController {

    private final AuthService authService;
    
    public AuthControllerImpl(AuthService authService) {
        this.authService = authService;

    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest request) {

        LoginResponse response = authService.login(request);
        
        return ResponseEntity.ok(response);
    }
    
}
