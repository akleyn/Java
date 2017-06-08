package com.swccorp.flooring.dao;


import com.swccorp.flooring.model.UpdateOrderRequest;

import java.time.LocalDate;

public interface UpdateOrderRequestDao
{
    void putRequest(UpdateOrderRequest order, LocalDate date);
    boolean hasUnsavedChanges();
    void saveChanges();
}
