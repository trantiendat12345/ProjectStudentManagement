CREATE TABLE audit_logs (
    audit_logs_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    accounts_id BIGINT UNSIGNED NOT NULL,
    action VARCHAR(255),
    table_name VARCHAR(100) NOT NULL,
    record_id BIGINT UNSIGNED NOT NULL,
    old_values JSON,
    new_values JSON,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT UNSIGNED NOT NULL,

    -- CONSTRAINT fk_audit_logs_accounts_id FOREIGN KEY (accounts_id) REFERENCES accounts(accounts_id),
    -- CONSTRAINT fk_audit_logs_created_by FOREIGN KEY (created_by) REFERENCES accounts(accounts_id)
);