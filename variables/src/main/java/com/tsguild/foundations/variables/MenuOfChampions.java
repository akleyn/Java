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
public class MenuOfChampions {
    public static void main(String[] args){
        String firstFood = "Udon Noodles";
        String secondFood = "Miso Soup";
        String thirdFood = "Sushi roll";
        
        double priceFirst = 12.99;
        double priceSecond = 6.99;
        double priceThird = 10.99;
        
        System.out.println("Welcome to Sushi Train!");
        System.out.println("Today's Menu Is...");
        
        System.out.println(firstFood + " $" + priceFirst);
        System.out.println(secondFood + " $" + priceSecond);
        System.out.println(thirdFood + " $" + priceThird);
    }
    
}
