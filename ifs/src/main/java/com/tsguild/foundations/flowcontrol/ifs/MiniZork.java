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
public class MiniZork {
    public static void main(String[] args){
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.println("Go to the house, or open the mailbox? ");
        
        String action = userInput.nextLine();
        
        if(action.equals("open the mailbox")){
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.println("Look inside or stick your hand in? ");
            action = userInput.nextLine();
            
            if(action.equals("keep looking")){
                System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                System.out.println("You've been eaten by a grue.");
                } else if(action.equals("run away")){
                    System.out.println("You run away screaming across the fields - looking very foolish");
                    System.out.println("But you are alive. Possibly a wise choice.");
                }
            
        } else if(action.equals("stick your hand in")){
            System.out.println("They took your hand! Luckily you still have another one.");
        }
    else if(action.equals("go to the house")){
        System.out.println("You found a giant pot of gold! Congratulations!");
        System.out.println("Do you want to save your money or buy a beach house?");
    }
        if(action.equals("save your money")){
            System.out.println("A wise choice! You can retire early!");
        } else if(action.equals("buy a beach house")){
            System.out.println("Florida is a great place for a beach house. It's much less expensive than California");
        }
    }
}
