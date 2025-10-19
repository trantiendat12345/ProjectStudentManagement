package com.example.student.management.be.response;

import com.example.student.management.be.resource.LoginResource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private final String token;
    private final LoginResource infLoginResource;
    
}
