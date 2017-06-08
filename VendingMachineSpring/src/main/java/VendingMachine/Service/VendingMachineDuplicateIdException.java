/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Service;

/**
 *
 * @author softwareguild
 */
public class VendingMachineDuplicateIdException extends RuntimeException {

    public VendingMachineDuplicateIdException(String message) {
        super(message);
    }

    public VendingMachineDuplicateIdException(String message, Throwable cause) {
        super(message, cause);
    }
}


