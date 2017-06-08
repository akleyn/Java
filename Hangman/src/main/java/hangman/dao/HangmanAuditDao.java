/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.dao;

/**
 *
 * @author softwareguild
 */
public interface HangmanAuditDao {
        public void writeAuditEntry(String entry) throws HangmanPersistenceException;

}
