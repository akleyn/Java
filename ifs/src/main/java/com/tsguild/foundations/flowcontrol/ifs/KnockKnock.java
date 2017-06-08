/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author Kleyn
 */
public class KnockKnock {
    public static void main(String[] args){
        Scanner inputReader = new Scanner (System.in);
        
        System.out.println("Knock Knock! Guess who!!");
        String nameGuess = inputReader.nextLine();
        
        if(nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println("... from the Future.");
        
        }
        else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
        // .equals compares the objects.
        // == is a binary operator that compares the memory addresss.
        // One method to deal with incorrect capitalization is to change the input to all lowercase
        // using the toLowerCase() method.
    }
}
