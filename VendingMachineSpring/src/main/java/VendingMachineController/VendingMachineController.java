/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachineController;

import VendingMachine.Service.VendingMachineDataValidationException;
import VendingMachine.Service.VendingMachineInsufficientFundsException;
import VendingMachine.Service.VendingMachineNoItemInventoryException;
import VendingMachine.Service.VendingMachineServiceLayer;
import VendingMachine.dto.Change;
import VendingMachine.dto.Item;
import vendingmachineUI.VendingMachineView;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {

        getItems();

        boolean keepGoing = true;
        int menuSelection;
        while (keepGoing) {
            menuSelection = view.printMenuAndGetSelection();
            switch (menuSelection) {
                case 1:
                    purchaseItem();
                    break;
                case 2:
                    remainingBalance();
                    break;
                case 3:
                    addFunds();
                    break;
                case 4:
                    change();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }

        view.goodbye();

        getItems();
    }

    private void remainingBalance() {
        BigDecimal funds = service.getFunds();
        view.remaining(funds);
    }

    private void change() {
        Change change = service.getChange();
        service.subtractChange(change);
        view.change(change);
        view.remaining(service.getFunds());
    }

    private void getItems() {
        try {
            this.service.getAllItems();
        } catch (VendingMachineDataValidationException ex) {
            view.exception();
        }
    }

    private void purchaseItem() {
        List<Item> items = service.getAllItems();

        printItems(items);

        String vendingSelection = view.makeSelection();
        Item purchasedItem = new Item(vendingSelection);

        try {
            service.purchaseItem(purchasedItem);
            view.dispensed();
            remainingBalance();
        } catch ( VendingMachineDataValidationException
                | VendingMachineInsufficientFundsException
                | VendingMachineNoItemInventoryException ex) {
            view.print(ex.getMessage());
        }
    }

    private void printItems(List<Item> items) {
        int i = 1;
        for(Item item: items){
            String itemCost = item.getCost().toString();
            String itemQuantity = Integer.toString(item.getQuantity());
            view.print("Item " + Integer.toString(i) + ": " +  item.getName() + " , Cost: $"+ itemCost + ",  Quantity: " + itemQuantity);
            i++;
        }
    }

    private void addFunds() {
        BigDecimal funds = view.addFunds();
        service.addFunds(funds);
        view.remaining(service.getFunds());
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}
