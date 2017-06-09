/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.math.BigDecimal;
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
        BigDecimalMath myMath = new BigDecimalMath();

        String annualInterest = "0";
        String principal;
        String quarterlyInterestRate ="0";
        int numYears = 0;
        String totalQuarterlyInterest ="0";
        String totalQuarterlyInterest1 = "0";
        String quarterAmount ="0";

        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the annual interest rate: ");
        annualInterest = userInput.nextLine();

        System.out.println("Please enter the principal amount: ");
        principal = userInput.nextLine();

        System.out.println("Please enter the number of years the money is to stay in the fund: ");
        numYears = userInput.nextInt();

        BigDecimal bdQuarterAmount = new BigDecimal(quarterAmount);
        BigDecimal bdAnnualInterest = new BigDecimal(annualInterest);
        BigDecimal bdPrincipal = new BigDecimal(principal);
        BigDecimal bdTotalQuarterlyInterest = new BigDecimal(totalQuarterlyInterest);
        BigDecimal bdTotalQuarterlyInterest1 = new BigDecimal(totalQuarterlyInterest1);
        BigDecimal bdQuarterlyInterestRate = new BigDecimal(quarterlyInterestRate);
        BigDecimal bdPrincipalUpdated = new BigDecimal(0);
        BigDecimal bdMoneyEarnedInYear = new BigDecimal(0);

        bdQuarterlyInterestRate = myMath.calculate(MathOperator.DIVIDE, bdAnnualInterest, BigDecimal.valueOf(4));

        for (int i = 1; i <= numYears; i++) {
            bdPrincipalUpdated = bdPrincipal;
            System.out.println("Year number: " + i + ", Beginning Principal: " + bdPrincipal.setScale(2, BigDecimal.ROUND_HALF_UP));

            for (int j = 1; j <= 4; j++) {
                
                bdQuarterAmount = myMath.calculate(MathOperator.DIVIDE, bdQuarterlyInterestRate, BigDecimal.valueOf(100));
                bdQuarterAmount = myMath.calculate(MathOperator.PLUS, bdQuarterAmount, BigDecimal.valueOf(1));
                bdQuarterAmount = myMath.calculate(MathOperator.MULTIPLY, bdPrincipal, bdQuarterAmount);

                //quarterAmount = principal * (1 + ((quarterlyInterestRate / 100)));
                bdTotalQuarterlyInterest = myMath.calculate(MathOperator.MINUS, bdQuarterAmount, bdPrincipal);

                //totalQuarterlyInterest = quarterAmount - principal;
                bdTotalQuarterlyInterest1 = myMath.calculate(MathOperator.PLUS, bdTotalQuarterlyInterest1, bdTotalQuarterlyInterest);

                //totalQuarterlyInterest1 += totalQuarterlyInterest;
                bdPrincipal = bdQuarterAmount;
            }
            bdMoneyEarnedInYear = myMath.calculate(MathOperator.MINUS, bdPrincipal, bdPrincipalUpdated );
            
            System.out.println("Interest earned for year: " + bdMoneyEarnedInYear.setScale(2, BigDecimal.ROUND_HALF_UP) + " , Ending Principal: " + bdPrincipal.setScale(2, BigDecimal.ROUND_HALF_UP));

        }

    }

}
