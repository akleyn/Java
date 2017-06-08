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
public class TheOrderOfThings {
    public static void main(String[] args){
        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;
        
        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "BRIGHT yellow";
        origin = "AlphaCentaurian";
        material = "platinum";
        purpose = "enlighten";
        
        noun = "dragons";
        
        // Use the + with strings, doesn't add it concatenates! (sticks them together)
        System.out.println("The number " + number + " that is " + opinion + " with a size " +  size + "that is fairly " + age + " and comes in a " + shape + " shape with the color " + color
                + " with an origin of "+ origin + "made from " + material + " whose purpose is to " + purpose + " the many " + noun);
        
    }
}
