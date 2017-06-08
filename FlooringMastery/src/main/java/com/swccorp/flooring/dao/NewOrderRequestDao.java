package com.swccorp.flooring.dao;


import com.swccorp.flooring.model.NewOrderRequest;

public interface NewOrderRequestDao
{
    void putRequest(NewOrderRequest order);
    boolean hasUnsavedChanges();
    void saveChanges();
}
