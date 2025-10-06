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
@Table(name = "class_sections")
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_delete = false")
public class ClassSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_sections_id")
    private Long classSectionId;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subjects_id", nullable = false)
    private Subject subjectId;

    @ManyToOne
    @JoinColumn(name = "term_id", referencedColumnName = "academic_terms_id", nullable = false)
    private AcademicTerm academicTermId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teachers_id", nullable = false)
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "rooms_id", nullable = false)
    private Room roomId;

    @Column(name = "max_students", nullable = false)
    private int maxStudents;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "classSectionId", cascade = CascadeType.ALL)
    private List<ClassSchedule> listClassSchedules;

    @OneToMany(mappedBy = "classSectionId", cascade = CascadeType.ALL)
    private List<Enrollment> listEnrollments;

    @OneToMany(mappedBy = "classSectionId", cascade = CascadeType.ALL)
    private List<AssessmentWeight> listAssessmentWeights;

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
