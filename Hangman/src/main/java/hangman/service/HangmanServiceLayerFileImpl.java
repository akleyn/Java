/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.service;

import hangman.dao.HangmanAuditDao;
import hangman.dao.HangmanDao;
import hangman.dao.HangmanDaoException;
import hangman.dao.HangmanPersistenceException;
import hangman.dto.Letter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author softwareguild
 */
public class HangmanServiceLayerFileImpl implements HangmanServiceLayer {

    private HangmanDao dao;
    private HangmanAuditDao auditDao;

    public HangmanServiceLayerFileImpl(HangmanDao dao, HangmanAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public Letter getLetter(char letter) throws HangmanPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Letter> getAllLetters() throws HangmanPersistenceException {
        return dao.getAllLetters();
    }
    
    @Override
    public ArrayList<String> getAllWords() throws HangmanPersistenceException{
        return dao.getAllWords();
    }

    @Override
    public List<Integer> getLetterWeightbyWordLength(int wordLength) {
        return dao.getLetterWeightbyWordLength(wordLength);
    }

    @Override
    public Letter chooseOnWeight(List<Letter> letters) {
        return dao.chooseOnWeight(letters);
    }

    @Override
    public Letter removeLetter(char letter) {
        return dao.removeLetter(letter);
    }

    @Override
    public void loadLibrary() throws HangmanDataValidationException {
        try {
            dao.loadLibrary();
        } catch (HangmanDaoException ex) {
            Logger.getLogger(HangmanServiceLayerFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadWords() throws HangmanDataValidationException {
        try {
            dao.loadWords();
        } catch (HangmanDaoException ex) {
            Logger.getLogger(HangmanServiceLayerFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


