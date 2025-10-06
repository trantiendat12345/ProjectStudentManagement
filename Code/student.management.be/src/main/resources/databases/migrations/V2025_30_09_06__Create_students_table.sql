CREATE TABLE students (
    students_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    student_code VARCHAR(20) NOT NULL UNIQUE,
    class_id BIGINT UNSIGNED NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    gender ENUM('Male', 'Female', 'Other') DEFAULT NULL,
    date_of_birth DATE DEFAULT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    identity_number VARCHAR(50) DEFAULT NULL UNIQUE,
    phone VARCHAR(15) DEFAULT NULL UNIQUE,
    address TEXT DEFAULT NULL,
    image_url VARCHAR(255) DEFAULT NULL,
    academic_year YEAR DEFAULT NULL,
    status ENUM('Active', 'Inactive', 'Graduated', 'Suspended') DEFAULT 'Active',
    advisor_id BIGINT UNSIGNED DEFAULT NULL,
    note TEXT,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_students_class_id FOREIGN KEY (class_id) REFERENCES student_classes(student_classes_id),
    CONSTRAINT fk_students_advisor_id FOREIGN KEY (advisor_id) REFERENCES teachers(teachers_id)
    -- CONSTRAINT fk_students_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);