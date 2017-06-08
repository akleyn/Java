/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.Service;

/**
 *
 * @author softwareguild
 */
public class DVDLibraryDuplicateIdException extends Exception{
    
    public DVDLibraryDuplicateIdException(String message){
        super(message);
    }
    
    public DVDLibraryDuplicateIdException(String message, Throwable cause){
        super(message, cause);
    }
}
