package com.example.student.management.be.security.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.student.management.be.constant.AccountConstant;
import com.example.student.management.be.constant.errors.ErrorConstant;
import com.example.student.management.be.dto.LoginDTO;
import com.example.student.management.be.entity.Account;
import com.example.student.management.be.repository.AccountRepository;
import com.example.student.management.be.request.LoginRequest;
import com.example.student.management.be.response.LoginResponse;
import com.example.student.management.be.security.service.BaseServiceSecurity;
import com.example.student.management.be.security.service.interfaces.AuthService;
import com.example.student.management.be.security.service.interfaces.JwtService;
import com.example.student.management.be.util.ErrorResource;

@Service
public class AuthServiceImpl extends BaseServiceSecurity implements AuthService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;
    
    @Override
    public Object login(LoginRequest request) {

        try {

            Account account = accountRepository.findByUsername(request.getUsername()).orElseThrow( () -> new BadCredentialsException(AccountConstant.USERNAME_OR_PASSWORD_INCORECT));

            if (!passwordEncoder.matches(request.getPassword(), account.getPassword())) {
                throw new BadCredentialsException(AccountConstant.USERNAME_OR_PASSWORD_INCORECT);
            }

            Long accountId = account.getAccountId();
            String username = account.getUsername();
            int roleId = account.getRoleId().getRoleId();
            Long studentId = account.getStudentId() != null ? account.getStudentId().getStudentId() : null;
            String fullNameStudent = account.getStudentId() != null ? account.getStudentId().getFullName() : null;
            String studentCode = account.getStudentId() != null ? account.getStudentId().getStudentCode() : null;
            Long classId = account.getStudentId() != null ? account.getStudentId().getStudentClassId().getStudentClassId() : null;
            Long teacherId = account.getTeacherId() != null ? account.getTeacherId().getTeacherId() : null;
            String fullNameTeacher = account.getTeacherId() != null ? account.getTeacherId().getFullName() : null;
            String teacherCode = account.getTeacherId() != null ? account.getTeacherId().getTeacherCode() : null;
            Long majorId = account.getTeacherId() != null ? account.getTeacherId().getMajorId().getMajorId() : null;

            LoginDTO infoLoginDTO = new LoginDTO(accountId, username, roleId, studentId, fullNameStudent, studentCode, classId, teacherId, fullNameTeacher, teacherCode, majorId);

            String token = jwtService.generateToken(accountId, username, roleId, studentCode, teacherCode);

            return new LoginResponse(token, infoLoginDTO);
            
        } catch (BadCredentialsException e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("message", e.getMessage());
            ErrorResource errorResource = new ErrorResource(ErrorConstant.LOGIN_ERROR, errors);
            return errorResource;
        }
        
    }
    
}
