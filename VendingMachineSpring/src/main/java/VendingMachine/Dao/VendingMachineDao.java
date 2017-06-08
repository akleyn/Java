/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dao;

import VendingMachine.dto.Item;

import java.util.List;

/**
 *
 * @author softwareguild
 */
public interface VendingMachineDao {

    List<Item> getAllItems();

    Item getItem(String item);
    
    void purchaseItem(Item item);
}
