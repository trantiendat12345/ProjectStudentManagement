package com.example.student.management.be.response;

import com.example.student.management.be.dto.LoginDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // không hiển thị những giá trị null
public class LoginResponse {

    private final String token;
    private final LoginDTO infoLoginDTO;

    public LoginResponse (String token, LoginDTO infoLoginDTO) {
        this.token = token;
        this.infoLoginDTO = infoLoginDTO;
    }
    
    public LoginDTO getInfoLoginDTO() {
        return infoLoginDTO;
    }

    public String getToken() {
        return token;
    }
    
}
