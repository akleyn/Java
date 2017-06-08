package com.swccorp.flooring.model;


import java.math.BigDecimal;

public class UpdateOrderRequest {
    private String customer;
    private String state;
    private String productType;
    private BigDecimal area;

    public UpdateOrderRequest(String customer, String state, String productType, BigDecimal area) {
        this.customer = customer;
        this.state = state;
        this.productType = productType;
        this.area = area;
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
        return "UpdateOrderRequest{" +
                "customer='" + customer + '\'' +
                ", state='" + state + '\'' +
                ", productType='" + productType + '\'' +
                ", area=" + area +
                '}';
    }
}
