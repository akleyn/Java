package com.swccorp.flooring.dao;

import com.swccorp.flooring.model.Order;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public interface OrderDao {
    Map<Long, Order> getOrdersForDate(LocalDate date);

    Optional<Order> getOrder(LocalDate date, long number);

    void putOrder(LocalDate date, Order order);

    boolean removeOrder(LocalDate date, long number);

    boolean hasUnsavedChanges();

    void saveChanges();
}
