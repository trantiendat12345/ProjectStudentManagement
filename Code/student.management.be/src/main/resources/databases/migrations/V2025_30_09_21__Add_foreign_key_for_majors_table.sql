ALTER TABLE majors
    ADD CONSTRAINT fk_majors_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
    ON DELETE SET NULL;