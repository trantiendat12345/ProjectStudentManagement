package com.example.student.management.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.management.be.entity.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
    
}
