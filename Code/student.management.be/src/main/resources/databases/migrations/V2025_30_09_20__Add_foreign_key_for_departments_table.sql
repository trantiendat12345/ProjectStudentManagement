ALTER TABLE departments
    ADD CONSTRAINT fk_departments_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
    ON DELETE SET NULL;