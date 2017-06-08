/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hangman.controller;

import hangman.dao.HangmanPersistenceException;
import hangman.dto.Letter;
import hangman.service.HangmanDataValidationException;
import hangman.service.HangmanServiceLayer;
import hangman.ui.HangmanView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class HangmanController {

    HangmanView view;
    private HangmanServiceLayer service;

    public HangmanController(HangmanServiceLayer service, HangmanView view) {
        this.service = service;
        this.view = view;

    }

    public void run() throws HangmanPersistenceException, HangmanDataValidationException {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {

            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1:                    
                    try{
                        this.service.loadLibrary();
                    } catch (HangmanDataValidationException ex) {
                        view.exception();
                    }
                    runProgram();
                    break;
                case 2:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }

        view.goodbye();

    }

    private void runProgram() throws HangmanDataValidationException, HangmanPersistenceException {
        service.loadWords();
        ArrayList<String> words = service.getAllWords();
        List<Letter> letterList = service.getAllLetters();
        //for(int i = 0; i < words.size(); i++){
            //System.out.print(words.get(i));
            int miss = 0;
            String s = words.get(2);
            char[] charArray = s.toCharArray();
            int charLength = charArray.length;
            
            List<Integer> letterWeights = service.getLetterWeightbyWordLength(charLength);
            for(int i = 0; i < letterWeights.size(); i++){
               System.out.println(letterWeights.get(i));
            }
            for(int i = 0; i< letterList.size(); i++){
                int weightUpdated = letterWeights.get(i);
                List<Integer> weightingList = new ArrayList<>();
                weightingList.add(weightUpdated);
                letterList.get(i).setWeight(weightingList);
            }
            Letter letter = service.chooseOnWeight(letterList);
            char letterUpdated = letter.getName();
            System.out.println(letterUpdated);
            
            
       // }
        
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }



}
