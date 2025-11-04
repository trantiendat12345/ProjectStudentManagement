package com.example.student.management.be.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // ✅ Cho phép tất cả request, bỏ qua xác thực
            )
            .httpBasic(httpBasic -> httpBasic.disable()) // tắt luôn basic auth
            .formLogin(form -> form.disable()); // tắt login form (nếu có)
        return http.build();
    }
    
}
