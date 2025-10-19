package com.example.student.management.be.seeder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.be.constant.StudentConstant;
import com.example.student.management.be.entity.Student;
import com.example.student.management.be.entity.StudentClass;
import com.example.student.management.be.repository.StudentClassRepository;
import com.example.student.management.be.repository.StudentRepository;
import com.example.student.management.be.seeder.base.RandomListName;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class StudentSeeder extends RandomListName implements CommandLineRunner {

    //6
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentClassRepository studentClassRepository;
    
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isEmptyTable()) {
            
            int numberOfClasses = 50;
            int studentsPerClass = 50;
            long studentCounter = 1;
            
            List<String> listNameStudent = listName(2500);

            List<StudentClass> studentClasses = studentClassRepository.findAll();

            List<Student> students = new ArrayList<>();

            for (int i = 0; i < numberOfClasses; i++) {
                StudentClass studentClass = studentClasses.get(i);
                for (int j =0; j < studentsPerClass; j++) {
                    int index = (int) (studentCounter - 1);
                    Student student = new Student();
                    student.setStudentCode(StudentConstant.CODE + studentCounter);
                    student.setStudentClassId(studentClass);
                    student.setFullName(listNameStudent.get(index));
                    student.setEmail("student" + studentCounter + "@gmail.com");
                    students.add(student);
                    studentCounter++;
                }
            }
            studentRepository.saveAll(students);
        }
    }
    
    private boolean isEmptyTable () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(studentId) FROM Student").getSingleResult();
        return count == 0;
    }
    
}
