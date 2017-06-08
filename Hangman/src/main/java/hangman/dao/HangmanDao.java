package hangman.dao;

import hangman.dto.Letter;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author softwareguild
 */
public interface HangmanDao {

    List<Letter> getAllLetters();
    
    ArrayList<String> getAllWords();

    char getLetter(char letter);

    Letter removeLetter(char letter);

    void loadLibrary() throws HangmanDaoException;

    List<Integer> getLetterWeightbyWordLength(int wordLength);

    Letter chooseOnWeight(List<Letter> letters);
    
    void loadWords() throws HangmanDaoException;

    }
