/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.dto;

import java.util.List;

/**
 *
 * @author softwareguild
 */
public class Letter {
    char name;
    List<Integer> weight;
    
    public Letter(char name){
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public List<Integer> getWeight() {
        return weight;
    }

    public void setWeight(List<Integer> weight) {
        this.weight = weight;
    }
    
    
}
