CREATE TABLE academic_terms (
    academic_terms_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    year INT NOT NULL,
    semester ENUM('Spring', 'Summer', 'Fall') DEFAULT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_academic_terms_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);