package com.example.student.management.be.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import com.example.student.management.be.util.enums.Semester;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "academic_terms")
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted = false")
public class AcademicTerm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academic_terms_id")
    private Long academicTermId;

    @Column(name = "year", nullable = false)
    private int year;

    @Enumerated(EnumType.STRING)
    @Column(name = "semester")
    private Semester semester;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "academicTermId", cascade = CascadeType.ALL)
    private List<Teaching> listTeachings;

    @OneToMany(mappedBy = "academicTermId", cascade = CascadeType.ALL)
    private List<ClassSection> listClassSections;

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
