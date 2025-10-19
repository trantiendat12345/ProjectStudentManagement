package com.example.student.management.be.seeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.student.management.be.constant.RoleConstant;
import com.example.student.management.be.entity.Account;
import com.example.student.management.be.entity.Student;
import com.example.student.management.be.entity.Teacher;
import com.example.student.management.be.repository.AccountRepository;
import com.example.student.management.be.repository.RoleRepository;
import com.example.student.management.be.repository.StudentRepository;
import com.example.student.management.be.repository.TeacherRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class AccountSeeder implements CommandLineRunner {

    //7

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isEmptyTable()) {
            String passwordEncode = passwordEncoder.encode("password");

            List<Teacher> teachers = teacherRepository.findAll();

            List<Student> students = studentRepository.findAll();

            for (int i = 1; i < 11; i++) {
                Account account = new Account();
                account.setUsername(String.format("user%02d@gmail.com", i));
                account.setPassword(passwordEncode);
                account.setRoleId(roleRepository.findById(RoleConstant.ADMIN).orElseThrow(() -> new RuntimeException(RoleConstant.ROLE_NOT_FOUND)));
                accountRepository.save(account);
            }

            for (int i = 11; i < 211; i++) {
                Account account = new Account();
                account.setUsername("user" + i + "@gmail.com");
                account.setPassword(passwordEncode);
                account.setRoleId(roleRepository.findById(RoleConstant.TEACHER).orElseThrow(() -> new RuntimeException(RoleConstant.ROLE_NOT_FOUND)));
                account.setTeacherId(teachers.get(i - 11));
                accountRepository.save(account);
            }
            
            for (int i = 212; i < 2712; i++) {
                Account account = new Account();
                account.setUsername("user" + i + "@gmail.com");
                account.setPassword(passwordEncode);
                account.setRoleId(roleRepository.findById(RoleConstant.STUDENT).orElseThrow(() -> new RuntimeException(RoleConstant.ROLE_NOT_FOUND)));
                account.setStudentId(students.get(i - 212));
                accountRepository.save(account);
            }
        }
    }

    private boolean isEmptyTable () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(accountId) FROM Account").getSingleResult();
        return count == 0;
    }
    
}
