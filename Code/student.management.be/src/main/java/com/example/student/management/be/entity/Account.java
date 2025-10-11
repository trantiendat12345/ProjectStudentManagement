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

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "roles_id", nullable = false)
    private Role roleId;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "students_id")
    private Student studentId;

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teachers_id")
    private Teacher teacherId;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL)
    private List<AuditLog> listAuditLogs;

    @OneToMany(mappedBy = "accountIdCreate", cascade = CascadeType.ALL)
    private List<AuditLog> listAuditLogsCreate;

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
