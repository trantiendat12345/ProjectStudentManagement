CREATE TABLE grade_components (
    grade_components_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    enrollment_id BIGINT UNSIGNED NOT NULL,
    component VARCHAR(100),
    score DECIMAL(5,2),
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_grade_components_enrollment_id FOREIGN KEY (enrollment_id) REFERENCES enrollments(enrollments_id),
    CONSTRAINT fk_grade_components_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);