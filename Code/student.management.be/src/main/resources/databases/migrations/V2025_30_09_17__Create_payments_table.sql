CREATE TABLE payments (
    payments_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT UNSIGNED NOT NULL,
    amount DECIMAL(10,2),
    description TEXT,
    status ENUM('pending', 'paid', 'overdue') NOT NULL DEFAULT 'pending',
    paid_at TIMESTAMP NULL DEFAULT NULL,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_payments_student_id FOREIGN KEY (student_id) REFERENCES students(students_id),
    CONSTRAINT fk_payments_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);