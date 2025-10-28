package com.example.student.management.be.controller.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.management.be.constant.uri.URI;
import com.example.student.management.be.request.LoginRequest;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
@RequestMapping(value = URI.API_AUTH)
public interface AuthController {

    @PostMapping(value = URI.LOGIN)
    ResponseEntity<?> login(@Valid @RequestBody LoginRequest request);
    
}
