ALTER TABLE students
    ADD CONSTRAINT fk_students_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
    ON DELETE SET NULL;