CREATE TABLE enrollments (
    enrollments_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT UNSIGNED NOT NULL,
    class_section_id BIGINT UNSIGNED NOT NULL,
    status ENUM('registered', 'cancelled', 'waitlist') NOT NULL DEFAULT 'registered',
    note TEXT,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- CONSTRAINT fk_enrollments_student_id FOREIGN KEY (student_id) REFERENCES students(students_id),
    -- CONSTRAINT fk_enrollments_class_section_id FOREIGN KEY (class_section_id) REFERENCES class_sections(class_sections_id),
    -- CONSTRAINT fk_enrollments_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);