CREATE TABLE assessment_weights (
    assessment_weights_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    class_section_id BIGINT UNSIGNED NOT NULL,
    component VARCHAR(100),
    weight DECIMAL(5,2),
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_assessment_weights_class_section_id FOREIGN KEY (class_section_id) REFERENCES class_sections(class_sections_id),
    CONSTRAINT fk_assessment_weights_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);