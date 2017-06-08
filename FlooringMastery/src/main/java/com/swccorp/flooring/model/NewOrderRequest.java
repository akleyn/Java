package com.swccorp.flooring.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewOrderRequest {
    private LocalDate date;
    private String customer;
    private String state;
    private String productType;
    private BigDecimal area;

    public NewOrderRequest(LocalDate date, String customer, String state, String productType, BigDecimal area) {
        this.date = date;
        this.customer = customer;
        this.state = state;
        this.productType = productType;
        this.area = area;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "NewOrderRequest{" +
                "date=" + date +
                ", customer='" + customer + '\'' +
                ", state='" + state + '\'' +
                ", productType='" + productType + '\'' +
                ", area=" + area +
                '}';
    }
}
