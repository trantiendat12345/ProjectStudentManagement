CREATE TABLE teachers (
    teachers_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    teacher_code VARCHAR(20) NOT NULL UNIQUE,
    major_id BIGINT UNSIGNED NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    gender ENUM('Male', 'Female', 'Other') DEFAULT NULL,
    phone VARCHAR(15) DEFAULT NULL UNIQUE,
    date_of_birth DATE DEFAULT NULL,
    address TEXT DEFAULT NULL,
    note TEXT,
    identity_number VARCHAR(50) DEFAULT NULL UNIQUE,
    image_url VARCHAR(255) DEFAULT NULL,
    status ENUM('Active', 'Inactive', 'retired') NOT NULL DEFAULT 'Active',
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_teachers_major_id FOREIGN KEY (major_id) REFERENCES majors(majors_id)
    -- CONSTRAINT fk_teachers_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);