/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.dto;

import java.util.ArrayList;

/**
 *
 * @author softwareguild
 */
public class Words {
    ArrayList<String> words = new ArrayList<>();

    public ArrayList<String> getWords() {
        return words;
    }

    public Words(ArrayList<String> words) {
        this.words = words;
    }
    
}
