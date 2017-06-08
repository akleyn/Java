package com.swccorp.flooring.dao;


import com.swccorp.flooring.model.UpdateOrderRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.*;

public class FileUpdateOrderRequestDao implements UpdateOrderRequestDao
{

    private static final DateTimeFormatter FILE_NAME_PATTERN = DateTimeFormatter.ofPattern("'UpdatedOrderRequests_'MMddYYYY'.txt'");

    private final Path baseDirectory;
    private final Map<LocalDate, Set<UpdateOrderRequest>> orderTable = new HashMap<>();
    private final Set<LocalDate> updatedDates = new HashSet<>();

    public FileUpdateOrderRequestDao(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    @Override
    public void putRequest(UpdateOrderRequest order, LocalDate date) {
        orderTable.computeIfAbsent(date, k -> new HashSet<>());
        orderTable.get(date).add(order);
        updatedDates.add(date);
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
            Collection<UpdateOrderRequest> orders = orderTable.get(date);
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

    private String marshallOrder(UpdateOrderRequest order) {
        String[] values = {
                String.valueOf(order.getCustomer()),
                String.valueOf(order.getArea()),
                String.valueOf(order.getProductType()),
                String.valueOf(order.getState()),
        };
        return String.join(",", values);
    }
}
