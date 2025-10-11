package com.example.student.management.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.management.be.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    
}
