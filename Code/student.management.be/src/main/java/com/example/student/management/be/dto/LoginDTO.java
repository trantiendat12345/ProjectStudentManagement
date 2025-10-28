package com.example.student.management.be.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // không hiển thị những giá trị null
public class LoginDTO {

    private Long accountId;
    private String username;
    private int roleId;
    private Long studentId;
    private String fullNameStudent;
    private String studentCode;
    private Long classId;
    private Long teacherId;
    private String fullNameTeacher;
    private String teacherCode;
    private Long majorId;

    public LoginDTO (Long accountId, String username, int roleId, Long studentId, String fullNameStudent, String studentCode, Long classId, Long teacherId, String fullNameTeacher, String teacherCode, Long majorId) {
        this.accountId = accountId;
        this.username = username;
        this.roleId = roleId;
        this.studentId = studentId;
        this.fullNameStudent = fullNameStudent;
        this.studentCode = studentCode;
        this.classId = classId;
        this.teacherId = teacherId;
        this.fullNameTeacher = fullNameTeacher;
        this.teacherCode = teacherCode;
        this.majorId = majorId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getClassId() {
        return classId;
    }

    public String getFullNameStudent() {
        return fullNameStudent;
    }

    public String getFullNameTeacher() {
        return fullNameTeacher;
    }

    public Long getMajorId() {
        return majorId;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public String getUsername() {
        return username;
    }
    
}
