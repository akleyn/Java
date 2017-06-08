/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.util.Scanner;

/**
 *
 * @author Kleyn
 */
public class InterestCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float annualInterest = 0;
        float principal = 0;
        float quarterlyInterestRate = 0;
        int numYears = 0;
        float totalQuarterlyInterest = 0;
        float totalQuarterlyInterest1 = 0;
        float quarterAmount = 0;
        
        
        
        
        
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Please enter the annual interest rate: ");
        annualInterest = userInput.nextFloat();
        
        System.out.println("Please enter the principal amount: ");
        principal = userInput.nextInt();
        
        System.out.println("Please enter the number of years the money is to stay in the fund: ");
        numYears = userInput.nextInt();
        
        quarterlyInterestRate = annualInterest/4;
        
        for(int i = 1; i <= numYears; i++){
            
            System.out.println("Year number: " + i + ", Beginning Principal: " + principal);
            
            
            for (int j = 1; j <= 4; j++){
                
                quarterAmount = principal * (1+((quarterlyInterestRate/100)));
                totalQuarterlyInterest = quarterAmount - principal;
                
                
                totalQuarterlyInterest1 += totalQuarterlyInterest;
                principal = quarterAmount;
            }
            
            
            
            
            System.out.println("Interest earned for year: " +  totalQuarterlyInterest1 + " , Ending Principal: " + principal);
           
        }
        
    }
    
}

