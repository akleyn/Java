package com.swccorp.flooring.dao;

public interface AuditDao {
    void writeAuditEntry(String entry);
}
