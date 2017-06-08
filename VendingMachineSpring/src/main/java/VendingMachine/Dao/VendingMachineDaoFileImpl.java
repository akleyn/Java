/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dao;

import VendingMachine.dto.Item;

import VendingMachineApp.BigDecimalMath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    public static final String VENDING_FILE = "vending.txt";
    public static final String DELIMITER = "::";

    private Map<String, Item> items = new HashMap<>();
    
    BigDecimalMath myMath = new BigDecimalMath();



    @Override
    public List<Item> getAllItems() {
        if(items.isEmpty()){
                loadLibrary();
        }
        
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(String item) {
        loadLibrary();
        return items.get(item);
    }

    @Override
    public void purchaseItem(Item item) {
        int itemQuantity = item.getQuantity();
        itemQuantity--;
        item.setQuantity(itemQuantity);
        items.put(item.getName(), item);
        saveLibrary();
    }


    private void loadLibrary() {
        Scanner scanner;
        try {
            
            scanner = new Scanner(new BufferedReader(new FileReader(VENDING_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException("-_- Could not load library data into memory.", e);
        }

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Item currentItem = new Item(currentTokens[0]);

            String bd = currentTokens[1];
            BigDecimal cost = new BigDecimal(bd);
            currentItem.setCost(cost);
            
            currentItem.setQuantity(Integer.parseInt(currentTokens[2]));
            if(currentItem.getQuantity() > 0){
            items.put(currentItem.getName(), currentItem);
            }
        }
        scanner.close();
    }

    
    private void saveLibrary() {
        try {

            List<Item> items = getAllItems();
            String line = "";
            for (Item currentItem : items) {

                line = line + currentItem.getName()
                        + DELIMITER + currentItem.getCost()
                        + DELIMITER + currentItem.getQuantity()
                        + "\n";

            }
            BufferedWriter out = new BufferedWriter(new FileWriter(VENDING_FILE));

            out.write(line);
            out.close();
        } catch (IOException e) {
            System.out.println("Exception!");
        }

    }

}
