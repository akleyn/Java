/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

/**
 *
 * @author softwareguild
 */
public interface AddressBookAuditDao {

    public void writeAuditEntry(String entry) throws AddressBookPersistenceException;

}
