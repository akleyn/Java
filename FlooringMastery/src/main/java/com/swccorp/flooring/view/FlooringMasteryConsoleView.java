package com.swccorp.flooring.view;

import com.swccorp.flooring.model.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FlooringMasteryConsoleView implements FlooringMasteryView {

    private final UserIO io;

    public FlooringMasteryConsoleView(UserIO io) {
        this.io = io;
    }

    @Override
    public int displayMenuAndReadSelection() {
        io.print("");
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Save Current Work");
        io.print("6. Quit");
        io.print("");
        return io.readInt("Please select from the above choices.", 1, 6);
    }

    @Override
    public void displayOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            io.print("No orders found");
        } else {
            orders.forEach(order -> {
                String orderString = orderToString(order);
                io.print(orderString);
            });
        }
    }

    private String orderToString(Order order) {
        return "{" +
                "number=" + order.getNumber() +
                ", customerName='" + order.getCustomerName() + '\'' +
                ", state='" + order.getTaxInfo().getStateAbbreviation() + '\'' +
                ", taxRate=" + order.getTaxInfo().getRate() +
                ", productType='" + order.getProduct().getType() + '\'' +
                ", area=" + order.getArea() +
                ", costPerSquareFoot=" + order.getProduct().getCostPerSquareFoot() +
                ", laborCostPerSquareFoot=" + order.getProduct().getLaborCostPerSquareFoot() +
                ", materialCost=" + order.getMaterialCost() +
                ", laborCost=" + order.getLaborCost() +
                ", tax=" + order.getTaxInfo() +
                ", total=" + order.getTotal() +
                '}';
    }

    @Override
    public LocalDate readOrderToSeeDate() {
        return io.readDate("Enter the date for which you want to see the orders");
    }

    @Override
    public NewOrderInput readNewOrderInput() {
        LocalDate date = io.readDate("Enter the date");
        String customer = io.readString("Enter the customer");
        String state = io.readString("Enter the state");
        String product = io.readString("Enter the product");
        BigDecimal area = io.readBigDecimal("Enter the area");
        NewOrderInput input = new NewOrderInput();
        input.setDate(date);
        input.setCustomer(customer);
        input.setState(state);
        input.setProductName(product);
        input.setArea(area);
        return input;
    }

    @Override
    public void displayUnableToCreateOrder(String errorMessage) {
        io.print("Unable to create order");
        io.print(errorMessage);
    }

    @Override
    public UpdateOrderInput readUpdateOrderInput(Order order) {
        String customer = io.readString("Enter the customer", order.getCustomerName());
        String state = io.readString("Enter the state", order.getTaxInfo().getStateAbbreviation());
        String product = io.readString("Enter the product type", order.getProduct().getType());
        BigDecimal area = io.readBigDecimal("Enter the area", order.getArea());
        UpdateOrderInput input = new UpdateOrderInput();
        input.setCustomer(customer);
        input.setState(state);
        input.setProductName(product);
        input.setArea(area);
        return input;
    }

    @Override
    public LocalDate readOrderToUpdateDate() {
        return io.readDate("Enter the date for the orders you want to edit");
    }

    @Override
    public long readOrderToUpdateNumber() {
        return io.readInt("Enter the number of the order you want to edit");
    }

    @Override
    public LocalDate readOrderToDeleteDate() {
        return io.readDate("Enter the date for the orders you want to delete");
    }

    @Override
    public long readOrderToDeleteNumber() {
        return io.readInt("Enter the number of the order you want to delete");
    }

    @Override
    public void displayNothingToSaveMessage() {
        io.print("Nothing to save");
    }

    @Override
    public void displayOrderDoesNotExist(LocalDate date, long number) {
        io.print("Order number " + number + " for date " + date + " does not exist");
    }

    @Override
    public boolean confirmNewOrder(NewOrderInput input) {
        io.print("Are you sure you want to add the following order? [Y/N]");
        io.print(input.toString());
        return io.readYesNo();
    }

    @Override
    public boolean confirmDeleteOrder(Order order) {
        io.print("Are you sure you want to delete the following order?");
        io.print(orderToString(order));
        return io.readYesNo();
    }

    @Override
    public void displayOrderDeleted(LocalDate date, long number) {
        io.print("Order number " + number + " for date " + date + " deleted");
    }

    @Override
    public void displayOrderNotDeleted(LocalDate date, long number) {
        io.print("Order number " + number + " for date " + date + " will not be deleted");
    }

    @Override
    public void displayWorkSaved() {
        io.print("Work saved");
    }

    @Override
    public boolean confirmExit() {
        io.print("Are you sure you want to exit?");
        return io.readYesNo();
    }

    @Override
    public boolean confirmSaveWork() {
        io.print("Do you want to save your work?");
        return io.readYesNo();
    }

    @Override
    public void displayUnableToUpdateOrder(String errorMessage) {
        io.print("Unable to update order");
        io.print(errorMessage);
    }
}
