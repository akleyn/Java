/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookController;

import AddressBook.dto.AddressBook;
import AddressBook.ui.AddressView;

import java.util.List;
import AddressBook.dao.AddressBookDao;
import AddressBook.dao.AddressBookDaoException;

/**
 *
 * @author softwareguild
 */
public class AddressBookController {

    AddressView view;
    AddressBookDao dao;
    
    
    public AddressBookController(AddressBookDao dao, AddressView view){
        this.dao = dao; 
        this.view = view;
    }

    public void run() {
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
                        this.dao.saveAddressBook();
                    } catch (AddressBookDaoException ex) {
                        view.exception();
                    }
                    break;
                case 8:
                    try {
                        this.dao.loadAddressBook();
                    } catch (AddressBookDaoException ex) {
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
    
    private void removeAddress(){
        
        String lastName = view.getAddressIdChoice();
        dao.removeAddress(lastName);
        view.displayRemoveSuccessBanner();
    }
    
    private void editAddress() {
        view.displayEditAddressBanner();
        AddressBook address = view.editAddressInfo();
        dao.editAddressInfo(address.getLastName(), address);
        view.displayEditSuccessBanner();
    }

    
    private void listAddresses(){
        List<AddressBook> addressList = dao.getAllAddresses();
        
        view.displayAddressList(addressList);
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createAddress(){
        view.displayCreateAddressBanner();
        AddressBook newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();
    }
    
    private void viewAddress(){
        String lastName = view.getAddressIdChoice();
        AddressBook address = dao.getAddress(lastName);
        view.displayAddress(address);
        
    }
    
    private void viewNumberAddresses(){
        List<AddressBook> addressList = dao.getAllAddresses();
        
        view.displayTotalNumberAddresses(addressList);
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
}
