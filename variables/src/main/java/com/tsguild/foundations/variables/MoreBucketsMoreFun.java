/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.variables;

/**
 *
 * @author Kleyn
 */
public class MoreBucketsMoreFun {
    public static void main(String[] args){
        // Declare ALL THE THINGS
        // (Usually it's a good idea to declare them at the beginning of the program)
        int butterflies, beetles, bugs;
        String color, size, shape, thing;
        double number;
        
        // Now give a couple of them some values
        butterflies = 2;
        beetles = 4;
        
        bugs = butterflies + beetles;
        System.out.println("There are only " + butterflies + " butterflies,");
        System.out.println("but " + bugs + " bugs total.");
        
        System.out.println("Uh oh, my dog ate one.");
        butterflies--;
        System.out.println("Now there are only " + butterflies + " butterflies left.");
        System.out.println("But still " + bugs + " bugs left, wait a minute!!!");
        System.out.println("Maybe I just counted wrong the first time...");
                
        // Question: What operator do we use to show that the dog ate the bug?
        // Answer: The deprecator operator, i.e. --
        
        // Question: Why does the number of bugs not change when we change the number of butterflies?
        // Answer: Bugs was set when the variable butterflies was equal to 6. Bugs was not updated to equal the 
        // new value of butterflies (3) plus the value of beetles (2).
    
}
}
