package com.example.student.management.be.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.student.management.be.constant.errors.ErrorConstant;
import com.example.student.management.be.controller.BaseController;
import com.example.student.management.be.controller.interfaces.AuthController;
import com.example.student.management.be.request.LoginRequest;
import com.example.student.management.be.response.LoginResponse;
import com.example.student.management.be.security.service.interfaces.AuthService;
import com.example.student.management.be.util.ErrorResource;

@Component
public class AuthControllerImpl extends BaseController implements AuthController {

    private final AuthService authService;
    
    public AuthControllerImpl(AuthService authService) {
        this.authService = authService;

    }

    @Override
    public ResponseEntity<?> login(LoginRequest request) {
        Object result = authService.login(request);
        
        if (result instanceof LoginResponse loginResponse) {
            return ResponseEntity.ok(loginResponse);
        }

        if (result instanceof ErrorResource errorResource) {
            return ResponseEntity.unprocessableEntity().body(errorResource);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorConstant.NETWORK_ERROR);
        
    }
    
}
