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
public class YourLifeInMovies {
    public static void main(String[] args){
        int birthYear;
        String name;
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Hey, let's play a game! What's your name?");
        name = inputReader.next();
        
        System.out.println("Ok, " + name + ", when were you born?");
        birthYear = inputReader.nextInt();
        System.out.println("Well " + name + "...");
        if(birthYear < 2005){
            System.out.println("Pixar's 'Up' came out half a decade ago.");
        }
        if(birthYear < 1995){
            System.out.println("The first Harry Potter came out over 15 years go.");
        }
        if(birthYear < 1985){
            System.out.println("Space Jam came out not last decade, but the one before THAT.");
        }
        if(birthYear < 1975){
            System.out.println("The original Jurassic Park release is closer to the lunar landing, than today.");
        }
        if(birthYear < 1965){
            System.out.println("MASH has been around for almost half a century!");
        }
    }
}
