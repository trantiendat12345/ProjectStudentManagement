package com.example.student.management.be.util;

import java.util.Map;

public class ErrorResource {
    
    private String message;
    private Map<String, String> errors;

    public ErrorResource (String message, Map<String, String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
