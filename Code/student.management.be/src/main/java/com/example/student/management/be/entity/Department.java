package com.example.student.management.be.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted = false")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departments_id")
    private Long departmentId;

    @Column(name = "department_name", nullable = false, unique = true)
    private String departmentName;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "majorId", cascade = CascadeType.ALL)
    private List<Major> listMajors;

    @OneToMany(mappedBy = "departmentId", cascade = CascadeType.ALL)
    private List<StudentClass> listStudentClasses;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
    
    @OneToOne
    @JoinColumn(name = "deleted_by", referencedColumnName = "accounts_id")
    private Account deletedBy;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreatedAndDeleted() {
        createdAt = LocalDateTime.now();
        deletedAt = null;
    }

    @PreUpdate
    protected void onUpdated() {
        updatedAt = LocalDateTime.now();
    }
    
}
