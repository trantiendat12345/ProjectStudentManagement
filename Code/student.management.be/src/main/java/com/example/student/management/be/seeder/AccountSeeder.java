package com.example.student.management.be.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.student.management.be.constant.RoleIdConstant;
import com.example.student.management.be.entity.Account;
import com.example.student.management.be.repository.AccountRepository;
import com.example.student.management.be.repository.RoleRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class AccountSeeder implements CommandLineRunner {

    //2

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isEmptyTable()) {
            String passwordEncode = passwordEncoder.encode("password");

            for (int i = 1; i < 11; i++) {
                Account account = new Account();
                account.setUsername("user0" + i + "@gmail.com");
                account.setPassword(passwordEncode);
                account.setRoleId(roleRepository.findById(RoleIdConstant.ADMIN).orElseThrow(() -> new RuntimeException("Role not found")));
                accountRepository.save(account);
            }

            for (int i = 11; i < 61; i++) {
                Account account = new Account();
                account.setUsername("user" + i + "@gmail.com");
                account.setPassword(passwordEncode);
                account.setRoleId(roleRepository.findById(RoleIdConstant.TEACHER).orElseThrow(() -> new RuntimeException("Role not found")));
                accountRepository.save(account);
            }
            
            for (int i = 61; i < 1071; i++) {
                Account account = new Account();
                account.setUsername("user" + i + "@gmail.com");
                account.setPassword(passwordEncode);
                account.setRoleId(roleRepository.findById(RoleIdConstant.STUDENT).orElseThrow(() -> new RuntimeException("Role not found")));
                accountRepository.save(account);
            }
        }
    }

    private boolean isEmptyTable () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(accountId) FROM Account").getSingleResult();
        return count == 0;
    }
    
}
