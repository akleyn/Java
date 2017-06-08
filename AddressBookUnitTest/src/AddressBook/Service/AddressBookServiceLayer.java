/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.Service;

import AddressBook.dao.AddressBookDaoException;
import AddressBook.dao.AddressBookPersistenceException;
import AddressBook.dto.AddressBook;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public interface AddressBookServiceLayer {

    public void addAddress(AddressBook address) throws AddressBookDuplicateIdException,
            AddressBookDataValidationException,
            AddressBookPersistenceException;

    public List<AddressBook> getAllAddresses() throws AddressBookPersistenceException;

    public AddressBook getAddress(String addressId) throws AddressBookPersistenceException;

    public AddressBook removeAddress(String addressId) throws AddressBookPersistenceException;
    
    public AddressBook editAddress(String addressId, AddressBook address) throws AddressBookPersistenceException;

    public void loadAddressBook() throws AddressBookDataValidationException;
    
    public void saveAddressBook() throws AddressBookDataValidationException;
}
