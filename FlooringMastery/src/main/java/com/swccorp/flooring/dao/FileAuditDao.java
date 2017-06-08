package com.swccorp.flooring.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Collections;

import static java.nio.file.StandardOpenOption.*;

public class FileAuditDao implements AuditDao {
    private final Path file;

    public FileAuditDao(Path file) {
        this.file = file;
    }

    @Override
    public void writeAuditEntry(String entry) {
        String line = LocalDateTime.now() + ": " + entry;
        try {
            Files.write(file, Collections.singleton(line), WRITE, CREATE, APPEND);
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }
}
