package com.swccorp.flooring.advice;

import com.swccorp.flooring.dao.AuditDao;
import com.swccorp.flooring.dao.PersistenceException;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LoggingAdvice {
    private final AuditDao auditDao;

    public LoggingAdvice(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void logMethodReturned(JoinPoint jp, Object returnValue) {
        String auditEntry = jp.getSignature().getName() + joinArguments(jp) + ": " + returnValue;
        writeAuditEntry(auditEntry);
    }

    public void logMethodThrewException(JoinPoint jp, Throwable e) {
        String auditEntry = jp.getSignature().getName() + joinArguments(jp) + " threw " +
                e.getClass().getName() + "(" + e.getMessage() + ")";
        writeAuditEntry(auditEntry);
    }

    void writeAuditEntry(String auditEntry) {
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (PersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    private String joinArguments(JoinPoint jp) {
        return "(" + Arrays.stream(jp.getArgs())
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + ")";
    }
}
