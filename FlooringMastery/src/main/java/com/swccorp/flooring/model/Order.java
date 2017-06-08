package com.swccorp.flooring.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {
    public static final int NUMBER_OF_FIELDS = 12;

    private long number;
    private String customerName;
    private TaxInfo taxInfo;
    private Product product;
    private BigDecimal area;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;

    public Order() {
    }

    public Order(Order order) {
        number = order.number;
        customerName = order.customerName;
        taxInfo = order.taxInfo;
        product = order.product;
        area = order.area;
        materialCost = order.materialCost;
        laborCost = order.laborCost;
        tax = order.taxInfo;
        total = order.total;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTaxInfo(TaxInfo taxInfo) {
        this.taxInfo = taxInfo;
    }

    public TaxInfo getTaxInfo() {
        return taxInfo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return number == order.number &&
                Objects.equals(customerName, order.customerName) &&
                Objects.equals(taxInfo, order.taxInfo) &&
                Objects.equals(product, order.product) &&
                Objects.equals(area, order.area) &&
                Objects.equals(materialCost, order.materialCost) &&
                Objects.equals(laborCost, order.laborCost) &&
                Objects.equals(tax, order.tax) &&
                Objects.equals(total, order.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, customerName, taxInfo, product, area, materialCost, laborCost, tax, total);
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", customerName='" + customerName + '\'' +
                ", taxInfo=" + taxInfo +
                ", product=" + product +
                ", area=" + area +
                ", materialCost=" + materialCost +
                ", laborCost=" + laborCost +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}
