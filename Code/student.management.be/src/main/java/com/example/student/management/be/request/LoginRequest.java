package com.example.student.management.be.request;

import com.example.student.management.be.constant.errors.ErrorConstant;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {
    
    @Email(message = ErrorConstant.USERNAME)
    @NotBlank(message = ErrorConstant.USERNAME_NOT_BLANK)
    private String username;

    @NotBlank(message = ErrorConstant.PASSWORD_NOT_BLANK)
    @Size(min = 6, message = ErrorConstant.MIN_PASSWORD)
    private String password;

    public LoginRequest () {

    }

    public LoginRequest (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
}
