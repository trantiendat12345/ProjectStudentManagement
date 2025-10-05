CREATE TABLE class_schedules (
    class_schedules_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    class_section_id BIGINT UNSIGNED NOT NULL,
    room_id BIGINT UNSIGNED NOT NULL,
    day_of_week ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') DEFAULT NULL,
    start_time TIME,
    end_time TIME,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    deleted_by BIGINT UNSIGNED NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_class_schedules_class_section_id FOREIGN KEY (class_section_id) REFERENCES class_sections(class_sections_id),
    CONSTRAINT fk_class_schedules_room_id FOREIGN KEY (room_id) REFERENCES rooms(rooms_id),
    CONSTRAINT fk_class_schedules_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
);