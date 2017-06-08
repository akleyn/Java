package com.swccorp.flooring.view;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewOrderInput {
    private LocalDate date;
    private String customer;
    private String state;
    private String productName;
    private BigDecimal area;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "{" +
                "date=" + date +
                ", customer='" + customer + '\'' +
                ", state='" + state + '\'' +
                ", productName='" + productName + '\'' +
                ", area=" + area +
                '}';
    }
}
