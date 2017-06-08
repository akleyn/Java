/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.service;

import hangman.dao.HangmanPersistenceException;
import hangman.dto.Letter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public interface HangmanServiceLayer {

    public Letter getLetter(char letter) throws HangmanPersistenceException;

    public List<Letter> getAllLetters() throws HangmanPersistenceException;
    
    public ArrayList<String> getAllWords() throws HangmanPersistenceException;

    public Letter chooseOnWeight(List<Letter> letters);

    public Letter removeLetter(char letter);

    public List<Integer> getLetterWeightbyWordLength(int wordLength);

    public void loadLibrary() throws HangmanDataValidationException;

    public void loadWords() throws HangmanDataValidationException;


}
