/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Dao;

/**
 *
 * @author softwareguild
 */
public class VendingMachineDaoException extends RuntimeException {

    public VendingMachineDaoException(String message) {
        super(message);
    }

    public VendingMachineDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
