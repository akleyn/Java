/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.ui;

import AddressBook.dto.AddressBook;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class AddressView {
        private UserIO io;
    
    public AddressView(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Please select the operation you wish to perform:");
        io.print("1. Add Address");
        io.print("2. Delete Address");
        io.print("3. Find Address");
        io.print("4. List Address Count");
        io.print("5. List All Addresses");
        io.print("6. Edit Address");
        io.print("7. Save Addresses");
        io.print("8. Load Addresses from File");
        io.print("9. Quit");
        
        return io.readInt("Please select from the above choices.", 1, 9);
    }
    
    public void goodbye(){
        io.print("Goodbye!");
    }
    
    public AddressBook getNewAddressInfo(){
        String firstName = io.readString("Please Enter First Name: ");
        String lastName = io.readString("Please Enter Last Name: ");
        String streetNumber = io.readString("Please Enter Street Number");
        String streetName = io.readString("Please Enter Street Name");
        String city = io.readString("Please Enter City");
        String state = io.readString("Please Enter State");
        String zipCode = io.readString("Please Enter Zip Code");
        AddressBook currentAddress = new AddressBook(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setStreetNumber(streetNumber);
        currentAddress.setStreetName(streetName);
        currentAddress.setCity(city);
        currentAddress.setState(state);
        currentAddress.setZipCode(zipCode);
        return currentAddress;
    }
    
    public AddressBook editAddressInfo(){
        String lastName = io.readString("Please Enter Last Name of Address to Edit: ");
        String firstName = io.readString("Please Enter First Name: ");
        String streetNumber = io.readString("Please Enter Street Number: ");
        String streetName = io.readString("Please Enter Street Name: ");
        String city = io.readString("Please Enter City: ");
        String state = io.readString("Please Enter State: ");
        String zipCode = io.readString("Please Enter Zip Code: ");
        AddressBook currentAddress = new AddressBook(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setStreetNumber(streetNumber);
        currentAddress.setStreetName(streetName);
        currentAddress.setCity(city);
        currentAddress.setState(state);
        currentAddress.setZipCode(zipCode);
        
        return currentAddress;
    }
    
    
    public String getAddressIdChoice(){
        return io.readString("Please Enter Last Name of Address to Find: ");
    }
    
    public void displayAddress(AddressBook address){
        if(address != null){
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getStreetNumber() + " " + address.getStreetName());
            io.print(address.getCity() + ", " + address.getState() + ", " + address.getZipCode());
            io.print("");
        } else{
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayAddressBanner(){
        io.print("=== Display Address ===");
    }
    
    public void displayCreateAddressBanner(){
        io.print("=== Create Address ===");
        
    }
    
    public void displayCreateSuccessBanner(){
        io.readString("Address successfully created. Please hit enter to continue.");
    }
    
    public void displayAddressList(List<AddressBook> addressList){
        for (AddressBook currentAddress: addressList){
            io.print(currentAddress.getFirstName() + " "
                    +currentAddress.getLastName() + " \n"
                    +currentAddress.getStreetNumber() + " "
                    +currentAddress.getStreetName() + " \n"
                    +currentAddress.getCity() + ", "
                    +currentAddress.getState() + ", "
                    +currentAddress.getZipCode() + "\n");
                    
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayAllBanner(){
        io.print("=== Display All Addresses ===");
    }
    

    public void displayRemoveSuccessBanner(){
        io.readInt("Address successfully removed. Please hit 1 to continue.");
    }
    
    public void displayExitBanner(){
        io.print("Good Bye!!!");
    }
    
    public void displayEditAddressBanner(){
        io.print("=== Edit Address ===");
    }
    
    public void displayEditSuccessBanner(){
        io.readInt("Address successfully edited. Please hit 1 to continue.");
    }
    
    public void displayTotalNumberAddresses(List<AddressBook> addressList){
        io.print("There are " + Integer.toString(addressList.size()) + " addresses in the book.");
    }
    
    public void displayUnknownCommandBanner(){
        io.print("Unknown Command!!!");
    }
    
    public void exception(){
        io.print("Exception!");
    }
}


