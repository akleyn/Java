/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dao;

import VendingMachine.dto.Item;

import VendingMachineApp.BigDecimalMath;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author softwareguild
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Item onlyItem;
    private List<Item> itemList = new ArrayList<>();
    private Map<String, Item> items = new HashMap<>();
    BigDecimalMath myMath = new BigDecimalMath();


    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("Famous Amos");
        BigDecimal bd = new BigDecimal("1.25");
        onlyItem.setCost(bd);
        onlyItem.setQuantity(10);

        items.put("Famous Amos", onlyItem);
        itemList.add(onlyItem);
    }


    @Override
    public List<Item> getAllItems() {
        return itemList;
    }

    @Override
    public Item getItem(String item) {
        if (item.equals(onlyItem.getName())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public void purchaseItem(Item item) {
        if (item.equals(onlyItem.getName())) {
           
            int itemQuantity = onlyItem.getQuantity();
            
            
            
             
            onlyItem.setQuantity(itemQuantity--);
        } else {
            
        }
    }


    
}


