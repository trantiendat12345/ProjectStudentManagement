package com.example.student.management.be.controller.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.management.be.request.LoginRequest;
import com.example.student.management.be.response.LoginResponse;
import com.example.student.management.be.util.uri.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(value = URI.API_AUTH)
public interface AuthController {

    @PostMapping(value = URI.LOGIN)
    public ResponseEntity<LoginResponse> login(LoginRequest request);
    
}
