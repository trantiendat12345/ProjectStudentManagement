ALTER TABLE student_classes
    ADD CONSTRAINT fk_student_classes_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
    ON DELETE SET NULL;