package com.example.student.management.be.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class AccountSeeder implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isEmptyTable()) {
            String passwordEncode = passwordEncoder.encode("password");
            System.out.println("password encode" + passwordEncode);
        }
    }

    private boolean isEmptyTable () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(accountId) FROM Account").getSingleResult();
        return count == 0;
    }
    
}
