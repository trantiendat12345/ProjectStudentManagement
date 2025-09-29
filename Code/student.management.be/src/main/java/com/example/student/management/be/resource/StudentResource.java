package com.example.student.management.be.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentResource {

    private final Long id;
    private final String email;
    private final String studentCode;
    private final String teacherCode;
    
}
