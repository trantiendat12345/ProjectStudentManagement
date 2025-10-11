package com.example.student.management.be.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.student.management.be.entity.Role;
import com.example.student.management.be.repository.RoleRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class RoleSeeder implements CommandLineRunner {

    //1
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isEmptyTable()) {
            Role admin = new Role();
            admin.setRoleId(1);
            admin.setRoleName("ADMIN");
            roleRepository.save(admin);

            Role student = new Role();
            student.setRoleId(3);
            student.setRoleName("STUDENT");
            roleRepository.save(student);

            Role teacher = new Role();
            teacher.setRoleId(2);
            teacher.setRoleName("TEACHER");
            roleRepository.save(teacher);
        }
    }

    private boolean isEmptyTable () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(roleId) FROM Role").getSingleResult();
        return count == 0;
    }
    
}
