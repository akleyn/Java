/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.Service;

import AddressBook.dao.AddressBookAuditDao;
import AddressBook.dao.AddressBookDao;
import AddressBook.dao.AddressBookDaoException;
import AddressBook.dao.AddressBookPersistenceException;
import AddressBook.dto.AddressBook;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class AddressBookServiceLayerImpl implements AddressBookServiceLayer {

    private AddressBookDao dao;
    private AddressBookAuditDao auditDao;

    public AddressBookServiceLayerImpl(AddressBookDao dao, AddressBookAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void addAddress(AddressBook address) throws AddressBookDuplicateIdException,
            AddressBookDataValidationException, AddressBookPersistenceException {

        if (dao.getAddress(address.getLastName()) != null) {
            throw new AddressBookDuplicateIdException("ERROR: Could not create student. Student Id "
                    + address.getLastName()
                    + " already exists.");
        }

        validateAddressData(address);
        dao.addAddress(address.getLastName(), address);
        auditDao.writeAuditEntry("Student " + address.getLastName() + " CREATED");
    }

    @Override
    public List<AddressBook> getAllAddresses() throws AddressBookPersistenceException {
        return dao.getAllAddresses();
    }

    @Override
    public AddressBook getAddress(String addressId) throws AddressBookPersistenceException {
        return dao.getAddress(addressId);
    }

    @Override
    public AddressBook editAddress(String addressId, AddressBook address) throws AddressBookPersistenceException {
        return dao.editAddress(addressId, address);
    }

    @Override
    public AddressBook removeAddress(String addressId) throws AddressBookPersistenceException {
        AddressBook removedAddress = dao.removeAddress(addressId);
        auditDao.writeAuditEntry("Address " + addressId + " REMOVED");
        return removedAddress;

    }

    private void validateAddressData(AddressBook address) throws AddressBookDataValidationException {
        if (address.getFirstName() == null || address.getFirstName().trim().length() == 0
                || address.getLastName() == null || address.getLastName().trim().length() == 0
                || address.getStreetName() == null || address.getStreetName().trim().length() == 0
                || address.getStreetNumber() == null || address.getStreetNumber().trim().length() == 0
                || address.getCity() == null || address.getCity().trim().length() == 0
                || address.getZipCode() == null || address.getZipCode().trim().length() == 0) {

            throw new AddressBookDataValidationException("ERROR: All fields [First Name, Last Name, Street Name, Street Number, City, Zip Code] are required");
        }
    }

    @Override
    public void loadAddressBook() throws AddressBookDataValidationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }

    @Override
    public void saveAddressBook() throws AddressBookDataValidationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }

}
