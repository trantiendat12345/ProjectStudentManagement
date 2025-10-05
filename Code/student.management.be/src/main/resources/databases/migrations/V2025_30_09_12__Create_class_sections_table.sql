CREATE TABLE class_sections (
    class_sections_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    subject_id BIGINT UNSIGNED NOT NULL,
    teacher_id BIGINT UNSIGNED NOT NULL,
    term_id BIGINT UNSIGNED NOT NULL,
    room_id BIGINT UNSIGNED NOT NULL,
    max_students INT NOT NULL,
    schedule VARCHAR(255),
    notes TEXT,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_class_sections_subject_id FOREIGN KEY (subject_id) REFERENCES subjects(subjects_id),
    CONSTRAINT fk_class_sections_teacher_id FOREIGN KEY (teacher_id) REFERENCES teachers(teachers_id),
    CONSTRAINT fk_class_sections_term_id FOREIGN KEY (term_id) REFERENCES academic_terms(academic_terms_id),
    CONSTRAINT fk_class_sections_room_id FOREIGN KEY (room_id) REFERENCES rooms(rooms_id),
    CONSTRAINT fk_class_sections_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);