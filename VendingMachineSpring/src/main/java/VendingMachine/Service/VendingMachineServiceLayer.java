/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Service;

import VendingMachine.dto.Change;
import VendingMachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public interface VendingMachineServiceLayer {
    
    void purchaseItem(Item item);

    void subtractFunds(Item item);

    void subtractChange(Change item);

    Item getItem(String item);

    List<Item> getAllItems();

    void remainingFunds(Item item);

    BigDecimal getFunds();

    void addFunds(BigDecimal amount);

    Change getChange();
}
