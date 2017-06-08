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
public class HangmanDaoException extends Exception {
    public HangmanDaoException(String message){
        super(message);
    }
    
    public HangmanDaoException(String message, Throwable cause){
        super(message, cause);
    }
}

