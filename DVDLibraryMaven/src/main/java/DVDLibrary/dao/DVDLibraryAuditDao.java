/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.dao;

/**
 *
 * @author softwareguild
 */
public interface DVDLibraryAuditDao {

    public void writeAuditEntry(String entry) throws DVDLibraryPersistenceException;

}
