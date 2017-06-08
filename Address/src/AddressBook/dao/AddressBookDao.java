/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

import AddressBook.dto.AddressBook;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public interface AddressBookDao {
    
    AddressBook addAddress(String AddressId, AddressBook address);
    
    
    List<AddressBook> getAllAddresses();
    
    int totalNumberAddresses();
    
    AddressBook getAddress(String addressId);
    
    AddressBook removeAddress(String addressId);
    
    AddressBook editAddressInfo(String lastName, AddressBook address);
    
    void saveAddressBook() throws AddressBookDaoException;
    
    void loadAddressBook() throws AddressBookDaoException;
    
}