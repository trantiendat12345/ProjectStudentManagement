package com.example.student.management.be.seeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.student.management.be.constant.MajorConstant;
import com.example.student.management.be.constant.TeacherConstant;
import com.example.student.management.be.constant.enums.TeacherStatus;
import com.example.student.management.be.entity.Teacher;
import com.example.student.management.be.repository.MajorRepository;
import com.example.student.management.be.repository.TeacherRepository;
import com.example.student.management.be.seeder.base.RandomListName;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class TeacherSeeder extends RandomListName implements CommandLineRunner {

    //5
    
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private MajorRepository majorRepository;
    
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (isEmptyTable()) {
            
            List<String> listNameTeacher = listName(200);

            for (int i = 1; i <= 50; i++) {
                Teacher teacher = new Teacher();
                teacher.setTeacherCode(TeacherConstant.CODE + i);
                teacher.setMajorId(majorRepository.findById(1L).orElseThrow( () -> new RuntimeException(MajorConstant.MAJOR_NOT_FOUND)));
                teacher.setFullName(listNameTeacher.get(i));
                teacher.setEmail("teacher" + i + "@gmail.con");
                teacher.setStatus(TeacherStatus.Active);
                teacherRepository.save(teacher);
            }

            for (int i = 51; i <= 100; i++) {
                Teacher teacher = new Teacher();
                teacher.setTeacherCode(TeacherConstant.CODE + i);
                teacher.setMajorId(majorRepository.findById(2L).orElseThrow( () -> new RuntimeException(MajorConstant.MAJOR_NOT_FOUND)));
                teacher.setFullName(listNameTeacher.get(i));
                teacher.setEmail("teacher" + i + "@gmail.con");
                teacher.setStatus(TeacherStatus.Active);
                teacherRepository.save(teacher);
            }

            for (int i = 101; i <= 150; i++) {
                Teacher teacher = new Teacher();
                teacher.setTeacherCode(TeacherConstant.CODE + i);
                teacher.setMajorId(majorRepository.findById(3L).orElseThrow( () -> new RuntimeException(MajorConstant.MAJOR_NOT_FOUND)));
                teacher.setFullName(listNameTeacher.get(i));
                teacher.setEmail("teacher" + i + "@gmail.con");
                teacher.setStatus(TeacherStatus.Active);
                teacherRepository.save(teacher);
            }

            for (int i = 151; i <= 200; i++) {
                Teacher teacher = new Teacher();
                teacher.setTeacherCode(TeacherConstant.CODE + i);
                teacher.setMajorId(majorRepository.findById(4L).orElseThrow( () -> new RuntimeException(MajorConstant.MAJOR_NOT_FOUND)));
                teacher.setFullName(listNameTeacher.get(i));
                teacher.setEmail("teacher" + i + "@gmail.con");
                teacher.setStatus(TeacherStatus.Active);
                teacherRepository.save(teacher);
            }

        }
    }

    private boolean isEmptyTable () {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(teacherId) FROM Teacher").getSingleResult();
        return count == 0;
    }
    
}
