/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

import AddressBook.dto.AddressBook;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author softwareguild
 */
public class AddressBookDaoFileImpl implements AddressBookDao{
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
     
    private Map<String, AddressBook> addresses = new HashMap<>();

    @Override
    public AddressBook addAddress(String lastName, AddressBook address) {
       AddressBook newAddress = addresses.put(lastName, address);
       return newAddress;
    }

    @Override
    public List<AddressBook> getAllAddresses() {
        return new ArrayList<AddressBook>(addresses.values());
    }

    @Override
    public AddressBook getAddress(String lastName) {
        return addresses.get(lastName);
    }
    
    @Override
    public AddressBook editAddress(String lastName, AddressBook address) {
        AddressBook newAddress = addresses.put(lastName, address);
        return newAddress;
    }

    @Override
    public AddressBook removeAddress(String lastName) {
        AddressBook removedAddress = addresses.remove(lastName);
        return removedAddress;
    }
    
    
    @Override
    public int totalNumberAddresses(){
        return addresses.size();
    }
    
    
    
    @Override
    public void loadAddressBook() throws AddressBookDaoException {
        Scanner scanner;
        try{
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e){
            throw new AddressBookDaoException("-_- Could not load roster data into memory.", e);
        }
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        
        String[] currentTokens;
        
        while(scanner.hasNextLine()){
            String currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            AddressBook currentAddress = new AddressBook(currentTokens[0]);
            
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setStreetNumber(currentTokens[2]);
            currentAddress.setStreetName(currentTokens[3]);
            currentAddress.setCity(currentTokens[4]);
            currentAddress.setState(currentTokens[5]);
            currentAddress.setZipCode(currentTokens[6]);
            
            addresses.put(currentAddress.getLastName(),currentAddress);
            
            
            
        }
        scanner.close();
    }
    
        @Override
    public void saveAddressBook() throws AddressBookDaoException {
        try {

            List<AddressBook> addresses = getAllAddresses();
            String line = "";
            for (AddressBook currentAddress : addresses) {

                line = line + currentAddress.getLastName()
                        + DELIMITER + currentAddress.getFirstName()
                        + DELIMITER + currentAddress.getStreetNumber()
                        + DELIMITER + currentAddress.getStreetName()
                        + DELIMITER + currentAddress.getCity()
                        + DELIMITER + currentAddress.getState()
                        + DELIMITER + currentAddress.getZipCode();

            }
            BufferedWriter out = new BufferedWriter(new FileWriter(ROSTER_FILE));

            out.write(line);
            out.close();
        } catch (IOException e) {
            System.out.println("Exception!");
        }
    
    
}
}