package com.example.student.management.be.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted = false")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accounts_id")
    private Long accountId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "roles_id", nullable = false)
    private Role roleId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "students_id")
    private Student studentId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teachers_id")
    private Teacher teacherId;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AuditLog> listAuditLogs;

    @OneToMany(mappedBy = "accountIdCreate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AuditLog> listAuditLogsCreate;

    @OneToMany(mappedBy = "academicTermId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AcademicTerm> listAcademicTerms;

    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> listAccounts;

    @OneToMany(mappedBy = "assessmentWeightId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AssessmentWeight> listAssessmentWeights;

    @OneToMany(mappedBy = "classScheduleId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClassSchedule> listClassSchedules;

    @OneToMany(mappedBy = "classSectionId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClassSection> listClassSections;

    @OneToMany(mappedBy = "departmentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Department> listDepartments;

    @OneToMany(mappedBy = "enrollmentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> listEnrollments;

    @OneToMany(mappedBy = "gradeComponentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GradeComponent> listGradeComponents;

    @OneToMany(mappedBy = "majorId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Major> listMajors;

    @OneToMany(mappedBy = "paymentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> listPayments;

    @OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Role> listRoles;

    @OneToMany(mappedBy = "roomId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Room> listRooms;

    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> listStudents;

    @OneToMany(mappedBy = "studentClassId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentClass> listStudentClasses;

    @OneToMany(mappedBy = "subjectId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subject> listSubjects;

    @OneToMany(mappedBy = "teacherId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Teacher> listTeachers;

    @OneToMany(mappedBy = "teachingId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Teaching> listTeachings;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.EAGER)
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
