package com.example.student.management.be.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.be.constant.DepartmentConstant;
import com.example.student.management.be.constant.MajorConstant;
import com.example.student.management.be.entity.Major;
import com.example.student.management.be.repository.DepartmentRepository;
import com.example.student.management.be.repository.MajorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class MajorSeeder implements CommandLineRunner {

    //3
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MajorRepository majorRepository;

    @Autowired 
    private DepartmentRepository departmentRepository;
    
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isEmptyTable()) {

            Major infomationSystem = new Major();
            infomationSystem.setMajorName(MajorConstant.INFORMATION_SYSTEM);
            infomationSystem.setDepartmentId(departmentRepository.findById(1L).orElseThrow( () -> new RuntimeException(DepartmentConstant.DEPARTMENT_NOT_FOUND)));
            majorRepository.save(infomationSystem);

            Major softwareTechnology = new Major();
            softwareTechnology.setMajorName(MajorConstant.SOFTWARE_TECHNOLOGY);
            softwareTechnology.setDepartmentId(departmentRepository.findById(1L).orElseThrow( () -> new RuntimeException(DepartmentConstant.DEPARTMENT_NOT_FOUND)));
            majorRepository.save(softwareTechnology);

            Major computerScience = new Major();
            computerScience.setMajorName(MajorConstant.COMPUTER_SCIENCE);
            computerScience.setDepartmentId(departmentRepository.findById(1L).orElseThrow( () -> new RuntimeException(DepartmentConstant.DEPARTMENT_NOT_FOUND)));
            majorRepository.save(computerScience);

            Major economicInformatics = new Major();
            economicInformatics.setMajorName(MajorConstant.ECONOMIC_INFORMATICS);
            economicInformatics.setDepartmentId(departmentRepository.findById(1L).orElseThrow( () -> new RuntimeException(DepartmentConstant.DEPARTMENT_NOT_FOUND)));
            majorRepository.save(economicInformatics);
        }
    }

    private boolean isEmptyTable () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(majorId) FROM Major").getSingleResult();
        return count == 0;
    }
    
}
