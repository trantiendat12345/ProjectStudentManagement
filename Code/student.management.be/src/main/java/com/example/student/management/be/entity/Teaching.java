package com.example.student.management.be.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "teaching")
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_delete = false")
public class Teaching {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teaching_id")
    private Long teachingId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teachers_id", nullable = false)
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subjects_id", nullable = false)
    private Subject subjectId;

    @ManyToOne
    @JoinColumn(name = "term_id", referencedColumnName = "academic_terms_id", nullable = false)
    private AcademicTerm academicTermId;

    @Column(name = "note")
    private String note;

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
