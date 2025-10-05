CREATE TABLE teaching (
    teaching_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    teacher_id BIGINT UNSIGNED NOT NULL,
    subject_id BIGINT UNSIGNED NOT NULL,
    term_id BIGINT UNSIGNED NOT NULL,
    note TEXT,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

    -- CONSTRAINT fk_teaching_teacher_id FOREIGN KEY (teacher_id) REFERENCES teachers(teachers_id),
    -- CONSTRAINT fk_teaching_subject_id FOREIGN KEY (subject_id) REFERENCES subjects(subjects_id),
    -- CONSTRAINT fk_teaching_term_id FOREIGN KEY (term_id) REFERENCES terms(terms_id),
    -- CONSTRAINT fk_teaching_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);