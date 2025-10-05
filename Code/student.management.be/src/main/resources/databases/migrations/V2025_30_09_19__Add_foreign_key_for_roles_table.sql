ALTER TABLE roles
    ADD CONSTRAINT fk_roles_deleted_by FOREIGN KEY (deleted_by) REFERENCES accounts(accounts_id)
    ON DELETE SET NULL;