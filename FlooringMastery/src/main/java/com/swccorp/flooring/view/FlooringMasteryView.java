package com.swccorp.flooring.view;

import com.swccorp.flooring.model.Order;

import java.time.LocalDate;
import java.util.List;

public interface FlooringMasteryView {
    int displayMenuAndReadSelection();

    void displayOrders(List<Order> orders);

    LocalDate readOrderToSeeDate();

    NewOrderInput readNewOrderInput();

    void displayUnableToCreateOrder(String errorMessage);

    UpdateOrderInput readUpdateOrderInput(Order orderToUpdate);

    LocalDate readOrderToUpdateDate();

    long readOrderToUpdateNumber();

    LocalDate readOrderToDeleteDate();

    long readOrderToDeleteNumber();

    void displayNothingToSaveMessage();

    void displayOrderDoesNotExist(LocalDate date, long number);

    boolean confirmNewOrder(NewOrderInput input);

    boolean confirmDeleteOrder(Order order);

    void displayOrderDeleted(LocalDate date, long number);

    void displayOrderNotDeleted(LocalDate date, long number);

    void displayWorkSaved();

    boolean confirmExit();

    boolean confirmSaveWork();

    void displayUnableToUpdateOrder(String errorMessage);
}
