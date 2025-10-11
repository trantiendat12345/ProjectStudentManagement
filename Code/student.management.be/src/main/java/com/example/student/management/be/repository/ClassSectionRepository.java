package com.example.student.management.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.management.be.entity.ClassSection;

@Repository
public interface ClassSectionRepository extends JpaRepository<ClassSection, Long> {
    
}
