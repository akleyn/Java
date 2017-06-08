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
    
    AddressBook addAddress(String AddressId, AddressBook address) throws AddressBookPersistenceException;
    
    
    List<AddressBook> getAllAddresses() throws AddressBookPersistenceException;
    
    int totalNumberAddresses()throws AddressBookPersistenceException;
    
    AddressBook getAddress(String addressId) throws AddressBookPersistenceException;
    
    AddressBook removeAddress(String addressId) throws AddressBookPersistenceException;
    
    AddressBook editAddress(String lastName, AddressBook address) throws AddressBookPersistenceException;
    
    void saveAddressBook() throws AddressBookDaoException;
    
    void loadAddressBook() throws AddressBookDaoException;
    
}