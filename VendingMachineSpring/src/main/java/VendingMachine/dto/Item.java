/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author softwareguild
 */
public class Item {

    private int quantity;
    private BigDecimal cost;
    private String name;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int quantity, BigDecimal cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }


    @Override
    public boolean equals(Object item) {
        if (this == item) {
            return true;
        }
        if (item == null || (this.getClass() != item.getClass())) {
            return false;
        }
        Item item1 = (Item) item;
        return (this.name!=null && name.equals(item1.name)) 
                && (this.quantity == item1.quantity) 
                && (this.cost == item1.cost);
    }
    
    @Override
    public String toString() {
        return "Quantity: " + quantity + " |Cost: " + cost + " |Name: " 
                + name;
    }

}
