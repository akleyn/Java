/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookController;

import AddressBook.Service.AddressBookDataValidationException;
import AddressBook.Service.AddressBookDuplicateIdException;
import AddressBook.Service.AddressBookServiceLayer;
import AddressBook.dto.AddressBook;
import AddressBook.ui.AddressView;

import java.util.List;
import AddressBook.dao.AddressBookDaoException;
import AddressBook.dao.AddressBookPersistenceException;

/**
 *
 * @author softwareguild
 */
public class AddressBookController {

    private AddressBookServiceLayer service;
    private AddressView view;
    
    
    public AddressBookController(AddressBookServiceLayer service, AddressView view){
        this.service = service; 
        this.view= view;
    }

    public void run() throws AddressBookDuplicateIdException,AddressBookDataValidationException, AddressBookPersistenceException{
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1:
                    createAddress();
                    break;
                case 2:
                    removeAddress();
                    break;
                case 3:
                    viewAddress();
                    break;
                case 4:
                    viewNumberAddresses();
                    break;
                case 5:
                    listAddresses();
                    break;
                case 6:
                    editAddress();
                    break;
                case 7:
                    try {
                        this.service.saveAddressBook();
                    } catch (AddressBookDataValidationException ex) {
                        view.exception();
                    }
                    break;
                case 8:
                    try {
                        this.service.loadAddressBook();
                    } catch (AddressBookDataValidationException ex) {
                        view.exception();
                    }
                    break;    
                case 9:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        view.goodbye();

    }
    
    private void removeAddress() throws AddressBookPersistenceException{
        
        String lastName = view.getAddressIdChoice();
        service.removeAddress(lastName);
        view.displayRemoveSuccessBanner();
    }
    
    private void editAddress() throws AddressBookPersistenceException {
        view.displayEditAddressBanner();
        AddressBook address = view.editAddressInfo();
        service.editAddress(address.getLastName(), address);
        view.displayEditSuccessBanner();
    }

    
    private void listAddresses()throws AddressBookPersistenceException{
        List<AddressBook> addressList = service.getAllAddresses();
        
        view.displayAddressList(addressList);
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createAddress() throws AddressBookDuplicateIdException,AddressBookDataValidationException, AddressBookPersistenceException {
        view.displayCreateAddressBanner();
        AddressBook newAddress = view.getNewAddressInfo();
        service.addAddress(newAddress);
        view.displayCreateSuccessBanner();
    }
    
    private void viewAddress()throws AddressBookPersistenceException{
        String lastName = view.getAddressIdChoice();
        AddressBook address = service.getAddress(lastName);
        view.displayAddress(address);
        
    }
    
    private void viewNumberAddresses() throws AddressBookPersistenceException{
        List<AddressBook> addressList = service.getAllAddresses();
        
        view.displayTotalNumberAddresses(addressList);
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
}
