package com.swccorp.flooring.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    public static final int NUMBER_OF_FIELDS = 3;

    private String type;
    private BigDecimal costPerSquareFoot;
    private BigDecimal laborCostPerSquareFoot;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(type, product.type) &&
                Objects.equals(costPerSquareFoot, product.costPerSquareFoot) &&
                Objects.equals(laborCostPerSquareFoot, product.laborCostPerSquareFoot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, costPerSquareFoot, laborCostPerSquareFoot);
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", costPerSquareFoot=" + costPerSquareFoot +
                ", laborCostPerSquareFoot=" + laborCostPerSquareFoot +
                '}';
    }
}
