/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

import AddressBook.dto.AddressBook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class AddressBookDaoStubImpl implements AddressBookDao {

    AddressBook onlyAddress;
    List<AddressBook> addressList = new ArrayList<>();
    
    public AddressBookDaoStubImpl(){
        onlyAddress = new AddressBook("Smith");
        onlyAddress.setFirstName("Joe");
        onlyAddress.setStreetNumber("1111");
        onlyAddress.setStreetName("Maple Street");
        onlyAddress.setCity("Jackson");
        onlyAddress.setState("Mississippi");
        onlyAddress.setZipCode("25252"); 
        
        addressList.add(onlyAddress);
    }

    @Override
    public AddressBook addAddress(String addressId, AddressBook address) throws AddressBookPersistenceException {
        if (addressId.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }
    }

    @Override
    public List<AddressBook> getAllAddresses() {
        return addressList;
    }

    @Override
    public int totalNumberAddresses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AddressBook getAddress(String addressId) {
        if (addressId.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }
    }

    @Override
    public AddressBook removeAddress(String addressId) {
        if (addressId.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }
    }

    @Override
    public AddressBook editAddress(String lastName, AddressBook address) {
        if (lastName.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }
    }

    @Override
    public void saveAddressBook() throws AddressBookDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadAddressBook() throws AddressBookDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
