package com.example.student.management.be.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.be.constant.DepartmentConstant;
import com.example.student.management.be.constant.MajorConstant;
import com.example.student.management.be.constant.StudentClassConstant;
import com.example.student.management.be.entity.StudentClass;
import com.example.student.management.be.repository.DepartmentRepository;
import com.example.student.management.be.repository.MajorRepository;
import com.example.student.management.be.repository.StudentClassRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class StudentClassSeeder implements CommandLineRunner {

    //4

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private MajorRepository majorRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isEmptyTable()) {

            for (int i = 1; i <= 10; i++) {
                StudentClass studentClass = new StudentClass();
                studentClass.setDepartmentId(departmentRepository.findById(1L).orElseThrow( () -> new RuntimeException(DepartmentConstant.DEPARTMENT_NOT_FOUND)));
                studentClass.setClassName(StudentClassConstant.DCCTCT66I + i);
                studentClassRepository.save(studentClass);
            }

            for (int i = 11; i <= 20; i++) {
                StudentClass studentClass = new StudentClass();
                studentClass.setMajorId(majorRepository.findById(1L).orElseThrow( () -> new RuntimeException(MajorConstant.MAJOR_NOT_FOUND)));
                studentClass.setClassName(StudentClassConstant.DCCTCT66_ + i);
                studentClassRepository.save(studentClass);
            }

            for (int i = 21; i <= 30; i++) {
                StudentClass studentClass = new StudentClass();
                studentClass.setMajorId(majorRepository.findById(2L).orElseThrow( () -> new RuntimeException(MajorConstant.MAJOR_NOT_FOUND)));
                studentClass.setClassName(StudentClassConstant.DCCTCT66_ + i);
                studentClassRepository.save(studentClass);
            }

            for (int i = 31; i <= 40; i++) {
                StudentClass studentClass = new StudentClass();
                studentClass.setMajorId(majorRepository.findById(3L).orElseThrow( () -> new RuntimeException(MajorConstant.MAJOR_NOT_FOUND)));
                studentClass.setClassName(StudentClassConstant.DCCTCT66_ + i);
                studentClassRepository.save(studentClass);
            }

            for (int i = 41; i <= 50; i++) {
                StudentClass studentClass = new StudentClass();
                studentClass.setMajorId(majorRepository.findById(4L).orElseThrow( () -> new RuntimeException(MajorConstant.MAJOR_NOT_FOUND)));
                studentClass.setClassName(StudentClassConstant.DCCTCT66_ + i);
                studentClassRepository.save(studentClass);
            }
        }
    }

    private boolean isEmptyTable () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(studentClassId) FROM StudentClass").getSingleResult();
        return count == 0;
    }
    
}
