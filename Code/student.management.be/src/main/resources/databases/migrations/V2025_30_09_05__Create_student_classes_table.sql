CREATE TABLE student_classes (
    student_classes_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_id BIGINT UNSIGNED,
    major_id BIGINT UNSIGNED,
    class_name VARCHAR(255) NOT NULL UNIQUE,
    note TEXT,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

    -- CONSTRAINT fk_student_classes_department_id FOREIGN KEY (department_id) REFERENCES departments(departments_id),
    -- CONSTRAINT fk_student_classes_major_id FOREIGN KEY (major_id) REFERENCES majors(majors_id),
    -- CONSTRAINT fk_student_classes_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);