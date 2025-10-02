CREATE TABLE accounts (
    accounts_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id INT UNSIGNED NOT NULL,
    student_id BIGINT UNSIGNED UNIQUE,
    teacher_id BIGINT UNSIGNED UNIQUE,
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- CONSTRAINT fk_accounts_role_id FOREIGN KEY (role_id) REFERENCES roles(roles_id),
    -- -- CONSTRAINT fk_accounts_student_id FOREIGN KEY (student_id) REFERENCES students(students_id),
    -- -- CONSTRAINT fk_accounts_teacher_id FOREIGN KEY (teacher_id) REFERENCES teachers(teachers_id),
    -- CONSTRAINT fk_accounts_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);