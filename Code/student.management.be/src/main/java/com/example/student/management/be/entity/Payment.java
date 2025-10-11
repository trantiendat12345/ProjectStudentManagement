package com.example.student.management.be.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLRestriction;

import com.example.student.management.be.util.enums.Paymentstatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted = false")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payments_id")
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "students_id", nullable = false)
    private Student studentId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Paymentstatus status;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

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
