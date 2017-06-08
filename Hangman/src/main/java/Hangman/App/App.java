/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hangman.App;

import Hangman.controller.HangmanController;
import hangman.dao.HangmanAuditDao;
import hangman.dao.HangmanAuditDaoFileImpl;
import hangman.dao.HangmanDao;
import hangman.dao.HangmanDaoFileImpl;
import hangman.dao.HangmanPersistenceException;
import hangman.service.HangmanDataValidationException;
import hangman.service.HangmanServiceLayer;
import hangman.service.HangmanServiceLayerFileImpl;
import hangman.ui.HangmanView;
import hangman.ui.UserIO;
import hangman.ui.UserIOFileImpl;

/**
 *
 * @author softwareguild
 */
public class App {

    public static void main(String[] args) throws HangmanDataValidationException, HangmanPersistenceException {
        UserIO myIo = new UserIOFileImpl();
        HangmanView myView = new HangmanView(myIo);
        HangmanDao myDao = new HangmanDaoFileImpl();
        HangmanAuditDao myAuditDao = new HangmanAuditDaoFileImpl();

        HangmanServiceLayer myService = new HangmanServiceLayerFileImpl(myDao, myAuditDao);
        HangmanController controller = new HangmanController(myService, myView);
        controller.run();

    }
}
