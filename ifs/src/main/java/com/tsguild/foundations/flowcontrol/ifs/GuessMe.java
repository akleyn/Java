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
public class GuessMe {
    public static void main(String[] args){
        int number;
        int secret = 20;
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Please pick a number: ");
        number = inputReader.nextInt();
        
        if(number == secret){
            System.out.println("Wow, nice guess! That was it!");
        }
        if(number < secret){
            System.out.println("Ha, nice try - too low! I chose " + secret + "");
        }
        if(number > secret){
            System.out.println("Too bad, way too high. I chose "+ secret);
        }
}
}
