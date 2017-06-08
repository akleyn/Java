package com.swccorp.flooring.controller;

import com.swccorp.flooring.model.Order;
import com.swccorp.flooring.service.DataModificationException;
import com.swccorp.flooring.model.NewOrderRequest;
import com.swccorp.flooring.service.OrderService;
import com.swccorp.flooring.model.UpdateOrderRequest;
import com.swccorp.flooring.view.FlooringMasteryView;
import com.swccorp.flooring.view.NewOrderInput;
import com.swccorp.flooring.view.UpdateOrderInput;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class FlooringMasteryController {
    private final FlooringMasteryView view;
    private final OrderService service;

    public FlooringMasteryController(FlooringMasteryView view, OrderService service) {
        this.view = view;
        this.service = service;
    }

    public void startApplication() {
        while (true) {
            int selection = view.displayMenuAndReadSelection();
            switch (selection) {
                case 1:
                    showOrders();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    updateOrder();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 5:
                    saveWork();
                    break;
                case 6:
                    boolean exit = beforeExit();
                    if (exit) {
                        return;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private void showOrders() {
        LocalDate date = view.readOrderToSeeDate();
        List<Order> orders = service.getOrdersForDate(date);
        view.displayOrders(orders);
    }

    private void addOrder() {
        NewOrderInput input = view.readNewOrderInput();
        if (view.confirmNewOrder(input)) {

            try {
                service.addOrder(new NewOrderRequest(input.getDate(),
                                                     input.getCustomer(),
                                                     input.getState(),
                                                     input.getProductName(),
                                                     input.getArea()));
            } catch (DataModificationException e) {
                view.displayUnableToCreateOrder(e.getMessage());
            }
        }
    }

    private void updateOrder() {
        LocalDate date = view.readOrderToUpdateDate();
        long number = view.readOrderToUpdateNumber();
        Optional<Order> orderOptional = service.getOrder(date, number);
        if (orderOptional.isPresent()) {
            Order existingOrder = orderOptional.get();
            UpdateOrderInput updateOrderInput = view.readUpdateOrderInput(existingOrder);
            try {
                service.updateOrder(date, existingOrder,
                        new UpdateOrderRequest(updateOrderInput.getCustomer(),
                                               updateOrderInput.getState(),
                                               updateOrderInput.getProductName(),
                                               updateOrderInput.getArea()));
            } catch (DataModificationException e) {
                view.displayUnableToUpdateOrder(e.getMessage());
            }
        } else {
            view.displayOrderDoesNotExist(date, number);
        }
    }

    private void deleteOrder() {
        LocalDate date = view.readOrderToDeleteDate();
        long number = view.readOrderToDeleteNumber();
        Optional<Order> orderOptional = service.getOrder(date, number);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            boolean delete = view.confirmDeleteOrder(order);
            if (delete) {
                service.deleteOrder(date, number);
                view.displayOrderDeleted(date, number);
            } else {
                view.displayOrderNotDeleted(date, number);
            }
        } else {
            view.displayOrderDoesNotExist(date, number);
        }
    }

    private void saveWork() {
        if (service.hasWorkToSave()) {
            service.saveWork();
            view.displayWorkSaved();
        } else {
            view.displayNothingToSaveMessage();
        }
    }

    private boolean beforeExit() {
        boolean exit = view.confirmExit();
        if (!exit) {
            return false;
        }
        if (service.hasWorkToSave()) {
            boolean saveWork = view.confirmSaveWork();
            if (saveWork) {
                service.saveWork();
                view.displayWorkSaved();
            }
        }
        return true;
    }
}
