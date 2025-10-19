package com.example.student.management.be.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.be.constant.DepartmentConstant;
import com.example.student.management.be.entity.Department;
import com.example.student.management.be.repository.DepartmentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class DepartmentSeeder implements CommandLineRunner {

    //2
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isEmptyTable()) {

            Department department = new Department();
            department.setDepartmentName(DepartmentConstant.INFORMATION_TECHNOLOGY);
            departmentRepository.save(department);

        }
    }

    private boolean isEmptyTable () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(departmentId) FROM Department").getSingleResult();
        return count == 0;
    }
    
}
