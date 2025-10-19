package com.example.student.management.be.request;

import com.example.student.management.be.constant.errors.ErrorConstant;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    
    @Email(message = ErrorConstant.USERNAME)
    @NotBlank(message = ErrorConstant.USERNAME_NOT_BLANK)
    private String username;

    @NotBlank(message = ErrorConstant.PASSWORD_NOT_BLANK)
    @Size(min = 6, message = ErrorConstant.MIN_PASSWORD)
    private String password;

}
