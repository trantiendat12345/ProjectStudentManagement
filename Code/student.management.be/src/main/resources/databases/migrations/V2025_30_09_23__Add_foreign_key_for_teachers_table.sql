ALTER TABLE teachers
    ADD CONSTRAINT fk_teachers_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
    ON DELETE SET NULL;