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
public class TriviaNight {
    public static void main(String[] args){
        int answer1;
        int answer2;
        int answer3;
        int correct = 0;
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code         2)Assembly Language");
        System.out.println("3) C#                  4)Machine Code");
        answer1 = inputReader.nextInt();
        System.out.println("YOUR ANSWER: " + answer1);
        if(answer1 == 4){
            correct++;
        } else{
        }
        
        
        System.out.println("Second QUESTION!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper         2)Alan Turing");
        System.out.println("3) Charles Babbage      4)Larry Page");
        answer2 = inputReader.nextInt();
        System.out.println("YOUR ANSWER: " + answer2);
        if(answer2 == 2){
            correct++;
        } else{
        }
        System.out.println("LAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity         2)The BattleStar Galatica");
        System.out.println("3) The USS Enterprise      4)The Millennium Falcon");
        answer3 = inputReader.nextInt();
        System.out.println("YOUR ANSWER: " + answer3);
        if(answer3 == 3){
            correct++;
        } else{
        }
        System.out.println("Nice job - you got " + correct + " correct!");
}}