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
public class FieldDay {
    public static void main(String[] args){
        String name;
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Please enter your last name: ");
        name = userInput.next();
        
        if(name.compareTo("Baggins") < 0){
            System.out.println("Aha! You're on the team 'Dark Wizards'.");
        } else if(name.compareTo("Dresden") > 0 && name.compareTo("Howl") < 0){
            System.out.println("Aha! You're on the team 'Moving Castles'.");
        } else if(name.compareTo("Howl") > 0 && name.compareTo("Potter") < 0){
            System.out.println("Aha! You're on the team 'Golden Snitches'.");
        } else if(name.compareTo("Potter") > 0 && name.compareTo("Vimes") < 0){
            System.out.println("Aha! You're on the team 'Night Guards'.");
        } else if(name.compareTo("Vimes") > 0){
            System.out.println("Aha! You're on the team 'Black Holes'.");
        }
        System.out.println("Good luck in the games!");
        
    }
}
