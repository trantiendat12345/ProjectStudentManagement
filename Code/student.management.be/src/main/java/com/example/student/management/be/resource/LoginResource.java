package com.example.student.management.be.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResource {

    private final Long accountId;
    private final String username;
    private final String fullName;
    private final String code;
    
}
