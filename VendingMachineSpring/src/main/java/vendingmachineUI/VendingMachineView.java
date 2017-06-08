/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachineUI;

import VendingMachine.dto.Change;

import java.math.BigDecimal;

/**
 *
 * @author softwareguild
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("1. Purchase Item");
        io.print("2. Remaining balance");
        io.print("3. Add Funds");
        io.print("4. Get change");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }
    public void print(String message){
        io.print(message);
    }

    public void print(int message){
        io.print(message);
    }

    public String makeSelection(){
        String selection = io.readString("Please enter the name of the item you wish to purchase: ");
        return selection;
    }
    
    public BigDecimal addFunds(){
        BigDecimal funds = io.readBigDecimal("Please enter cash and/or coin amount: ");
        return funds;
    }
    
    public void insufficientFunds(){
        io.print("Insufficient funds, please add funds.");
    }
    
    public void incorrectEntry(){
        io.print("Please enter a valid option");
    }


    public void dispensed(){
        io.print("You change is being dispensed: ");
    }

    public void goodbye(){
        io.print("Goodbye!");
    }
    
    public void displayUnknownCommandBanner(){
        io.print("Unknown command.");
    }
    
    public void exception(){
        io.print("Exception!");
    }

    public void change(Change change) {
        StringBuilder sb = new StringBuilder("Your change is; ");
        sb.append(change.getNumberOfQuarters()).append(" quarters, ");
        sb.append(change.getNumberOfDimes()).append(" dimes, ");
        sb.append(change.getNumberOfNickels()).append(" nickels, ");
        sb.append(change.getNumberOfPennies()).append(" pennies");

        io.print(sb.toString());
    }

    public void remaining(BigDecimal remaining) {
        io.print("Your remaining balance: $" + remaining);
    }
}
