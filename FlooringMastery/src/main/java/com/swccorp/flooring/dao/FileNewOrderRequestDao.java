package com.swccorp.flooring.dao;


import com.swccorp.flooring.model.NewOrderRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.*;

public class FileNewOrderRequestDao implements NewOrderRequestDao
{

    private static final DateTimeFormatter FILE_NAME_PATTERN = DateTimeFormatter.ofPattern("'NewOrderRequests_'MMddYYYY'.txt'");

    private final Path baseDirectory;
    private final Map<LocalDate, Set<NewOrderRequest>> orderTable = new HashMap<>();
    private final Set<LocalDate> updatedDates = new HashSet<>();

    public FileNewOrderRequestDao(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    @Override
    public void putRequest(NewOrderRequest order) {
        orderTable.computeIfAbsent(order.getDate(), k -> new HashSet<>());
        orderTable.get(order.getDate()).add(order);
        updatedDates.add(order.getDate());
    }


    @Override
    public boolean hasUnsavedChanges() {
        return !updatedDates.isEmpty();
    }

    @Override
    public void saveChanges() {
        updatedDates.forEach(this::persistOrdersForDate);
        updatedDates.clear();
    }
    private void persistOrdersForDate(LocalDate date) {
        Path file = getOrdersFile(date);
        try {
            Collection<NewOrderRequest> orders = orderTable.get(date);
            if (orders.isEmpty()) {
                Files.deleteIfExists(file);
            } else {
                List<String> lines = orders.stream().map(this::marshallOrder).collect(Collectors.toList());
                Files.write(file, lines, WRITE, TRUNCATE_EXISTING, CREATE);
            }
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    private Path getOrdersFile(LocalDate date) {
        String simpleFileName = date.format(FILE_NAME_PATTERN);
        return baseDirectory.resolve(simpleFileName);
    }

    private String marshallOrder(NewOrderRequest order) {
        String[] values = {
                String.valueOf(order.getCustomer()),
                String.valueOf(order.getArea()),
                String.valueOf(order.getDate()),
                String.valueOf(order.getProductType()),
                String.valueOf(order.getState()),
        };
        return String.join(",", values);
    }
}
