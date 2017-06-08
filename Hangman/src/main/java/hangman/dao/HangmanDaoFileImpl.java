/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.dao;

import hangman.dto.Letter;
import hangman.dto.Words;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author softwareguild
 */
public class HangmanDaoFileImpl implements HangmanDao {

    public static final String LIBRARY_FILE = "Word_Weights.txt";
    public static final String DELIMITER = "::";
    public static final String LIBRARY_FILE2 = "words_50000.txt";
    private Map<Character, Letter> letters = new HashMap<>();
    private ArrayList<String> words = new ArrayList<>();
    
    

    @Override
    public char getLetter(char letter) {
        char updatedLetter = '*';
        for (Entry<Character, Letter> ee : letters.entrySet()) {
            char key = ee.getKey();
            if (key == letter) {
                updatedLetter = letter;
            } else {
                letter = letter;
            }
        }

        return updatedLetter;
    }

    @Override
    public void loadLibrary() throws HangmanDaoException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new HangmanDaoException("-_- Could not load library data into memory.", e);
        }
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER

        String[] currentTokens;
        

        while (scanner.hasNextLine()) {
            ArrayList<Integer> weights = new ArrayList<>();
            String currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            String s = currentTokens[0];

            Letter currentLetter = new Letter(s.charAt(1));
            int letterWeight = 0;
            for (int i = 1; i < currentTokens.length; i++) {
                letterWeight = Integer.parseInt(currentTokens[i]);
                weights.add(letterWeight);
            }
            
            currentLetter.setWeight(weights);
            letters.put(currentLetter.getName(), currentLetter);

        }
        scanner.close();
    }

    @Override
    public List<Letter> getAllLetters() {
        return new ArrayList<Letter>(letters.values());
    }
    
    @Override
    public ArrayList<String> getAllWords(){
        return words;
    }

    @Override
    public Letter removeLetter(char letter) {
        Letter removedLetter = letters.remove(letter);
        return removedLetter;
    }

    @Override
    public List<Integer> getLetterWeightbyWordLength(int wordLength) {
        List<Integer> finalWeights = new ArrayList<>();
        double completeWeight = 0.0;
        for (Entry<Character, Letter> ee : letters.entrySet()) {

            char key = ee.getKey();
            Letter values = ee.getValue();
            List<Integer> letterWeights = values.getWeight();
            
                finalWeights.add(letterWeights.get(wordLength - 1));
            
        }
        return finalWeights;
    }

    @Override
    public Letter chooseOnWeight(List<Letter> letterNew) {

        int completeWeight = 0;
        int completeWeightUpdated = 0;
        List<Integer> updatedWeightList = new ArrayList<>();
        for (Letter letter : letterNew) {
            updatedWeightList = letter.getWeight();
            for (int i = 0; i < updatedWeightList.size(); i++) {
                completeWeight += updatedWeightList.get(i);

            }
            completeWeightUpdated += completeWeight;
        }

        int countWeightUpdated = 0;
        List<Integer> updatedCountList = new ArrayList<>();
        double r = Math.random() * completeWeight;
        double countWeight = 0.0;
        for (Letter letter : letterNew) {
            updatedCountList = letter.getWeight();
            for (int i = 0; i < updatedWeightList.size(); i++) {
                countWeight += updatedCountList.get(i);
            }
            countWeightUpdated += countWeight;

            if (countWeightUpdated >= r) {
                return letter;
            }
        }
        throw new RuntimeException("Should never be shown.");
    }

    @Override
    public void loadWords() throws HangmanDaoException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE2)));
        } catch (FileNotFoundException e) {
            throw new HangmanDaoException("-_- Could not load library data into memory.", e);
        }
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER

        String[] currentTokens;
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            
           

            
            
            words.add(currentLine);

        }
        Words word = new Words(words);
        scanner.close();

    }


}
