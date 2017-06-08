package com.swccorp.flooring.service;

import com.swccorp.flooring.dao.*;
import com.swccorp.flooring.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static java.math.RoundingMode.HALF_UP;

abstract public class OrderService {
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    final OrderDao orderDao;
    final NewOrderRequestDao newOrderRequestDao;
    final UpdateOrderRequestDao updateOrderRequestDao;

    private final TaxDao taxDao;
    private final ProductDao productDao;

    public OrderService(OrderDao orderDao, NewOrderRequestDao newOrderRequestDao, UpdateOrderRequestDao updateOrderRequestDao, TaxDao taxDao, ProductDao productDao) {
        this.orderDao = orderDao;
        this.newOrderRequestDao = newOrderRequestDao;
        this.updateOrderRequestDao = updateOrderRequestDao;
        this.taxDao = taxDao;
        this.productDao = productDao;
    }

    public static OrderService create(String mode, OrderDao orderDao, TaxDao taxDao, ProductDao productDao,  NewOrderRequestDao newOrderRequestDao, UpdateOrderRequestDao updateOrderRequestDao) {
        mode = mode.toLowerCase().trim();
        switch (mode) {
            case "prod":
                return new OrderServiceProd(orderDao, newOrderRequestDao, updateOrderRequestDao, taxDao, productDao);
            case "training":
                return new OrderServiceTraining(orderDao, newOrderRequestDao, updateOrderRequestDao, taxDao, productDao);
            default:
                throw new IllegalArgumentException("Unknown mode " + mode + ". Expected prod or training");
        }
    }

    public List<Order> getOrdersForDate(LocalDate date) {
        Map<Long, Order> orderByNumber = orderDao.getOrdersForDate(date);
        return new ArrayList<>(orderByNumber.values());
    }

    private long getNextOrderNumberForDate(LocalDate date) {
        Map<Long, Order> orderByNumber = orderDao.getOrdersForDate(date);
        OptionalLong maxNumber = orderByNumber.keySet().stream().mapToLong(Long::longValue).max();
        if (maxNumber.isPresent()) {
            return maxNumber.getAsLong() + 1;
        } else {
            return 1;
        }
    }

    public void addOrder(NewOrderRequest request) throws DataModificationException {
        LocalDate date = request.getDate();
        long number = getNextOrderNumberForDate(date);
        String state = request.getState();
        String productType = request.getProductType();
        Product product = getProduct(productType);
        TaxInfo taxInfo = getTaxInfo(state);
        BigDecimal area = request.getArea();

        newOrderRequestDao.putRequest(request);

        Order order = new Order();
        order.setNumber(number);
        order.setCustomerName(request.getCustomer());
        order.setTaxInfo(taxInfo);
        order.setProduct(product);
        order.setArea(area);
        calculateCosts(order, product, area, taxInfo);
        orderDao.putOrder(date, order);
    }

    public TaxInfo getTaxInfo(String state) throws DataModificationException {
        Optional<TaxInfo> taxInfoOptional = taxDao.getTaxForState(state);
        return taxInfoOptional.orElseThrow(() ->
                new DataModificationException("No tax information for state " + state + " found"));
    }

    public Product getProduct(String productType) throws DataModificationException {
        Optional<Product> productOptional = productDao.getProductByType(productType);
        return productOptional.orElseThrow(() ->
                new DataModificationException("No product for type " + productType + " found"));
    }

    private void calculateCosts(Order order, Product product, BigDecimal area, TaxInfo taxInfo) {
        BigDecimal costPerSquareFoot = product.getCostPerSquareFoot();
        BigDecimal laborCostPerSquareFoot = product.getLaborCostPerSquareFoot();
        BigDecimal materialCost = costPerSquareFoot.multiply(area).setScale(2, HALF_UP);
        BigDecimal laborCost = laborCostPerSquareFoot.multiply(area).setScale(2, HALF_UP);
        BigDecimal taxValue = materialCost.add(laborCost).multiply(taxInfo.getRate().divide(HUNDRED)).setScale(2, HALF_UP);
        BigDecimal total = materialCost.add(laborCost).add(taxValue);
        order.setMaterialCost(materialCost);
        order.setLaborCost(laborCost);
        order.setTax(taxValue);
        order.setTotal(total);
    }

    public Optional<Order> getOrder(LocalDate date, long number) {
        return orderDao.getOrder(date, number);
    }

    public boolean updateOrder(LocalDate date, Order orderToUpdate, UpdateOrderRequest request) throws DataModificationException {
        String state = request.getState();
        String productType = request.getProductType();
        BigDecimal area = request.getArea();
        TaxInfo taxInfo = getTaxInfo(state);
        Order updatedOrder = new Order(orderToUpdate);
        updatedOrder.setCustomerName(request.getCustomer());
        updatedOrder.setTaxInfo(taxInfo);
        Product product = getProduct(productType);
        updatedOrder.setProduct(product);
        updatedOrder.setArea(area);
        calculateCosts(updatedOrder, product, area, taxInfo);
        if (!updatedOrder.equals(orderToUpdate)) {

            updateOrderRequestDao.putRequest(request, date);
            orderDao.putOrder(date, updatedOrder);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteOrder(LocalDate date, long number) {
        return orderDao.removeOrder(date, number);
    }

    public abstract void saveWork();

    public abstract boolean hasWorkToSave();
}
