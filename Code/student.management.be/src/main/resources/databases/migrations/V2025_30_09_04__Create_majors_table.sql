CREATE TABLE majors (
    majors_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_id BIGINT UNSIGNED NOT NULL,
    major_name VARCHAR(255) NOT NULL UNIQUE,
    note TEXT,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

    -- CONSTRAINT fk_majors_department_id FOREIGN KEY (department_id) REFERENCES departments(departments_id),
    -- CONSTRAINT fk_majors_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);