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
import jakarta.persistence.ManyToOne;
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
@Table(name = "student_classes")
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_delete = false")
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_classes_id")
    private Long studentClassId;
    
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "departments_id")
    private Department departmentId;

    @ManyToOne
    @JoinColumn(name = "major_id", referencedColumnName = "majors_id")
    private Major majorId;

    @Column(name = "class_name", nullable = false, unique = true)
    private String className;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "studentClassId", cascade = CascadeType.ALL)
    private List<Student> listStudents;

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
