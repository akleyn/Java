/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.Service;

/**
 *
 * @author softwareguild
 */
public class AddressBookDuplicateIdException extends Exception{
    
    public AddressBookDuplicateIdException(String message){
        super(message);
    }
    
    public AddressBookDuplicateIdException(String message, Throwable cause){
        super(message, cause);
    }
}
