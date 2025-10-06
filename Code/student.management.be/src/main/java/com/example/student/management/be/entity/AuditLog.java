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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "audit_logs")
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_delete = false")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_logs_id")
    private Long auditLogId;

    @ManyToOne
    @JoinColumn(name = "accounts_id", referencedColumnName = "accounts_id", nullable = false)
    private Account accountId;

    @Column(name = "action")
    private String action;

    @Column(name = "table_name", nullable = false)
    private String tableName;

    @Column(name = "record_id", nullable = false)
    private Long recordId;

    @Column(name = "old_values")
    private String oldValue;

    @Column(name = "new_values")
    private String newValue;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "accounts_id", nullable = false)
    private Account accountIdCreate;
    
}
