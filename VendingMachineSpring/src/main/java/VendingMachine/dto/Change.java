/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author softwareguild
 */
public class Change {

    private final static int QUARTER_VALUE = 25;
    private final static int DIME_VALUE = 10;
    private final static int NICKEL_VALUE = 5;
    private final static int PENNIE_VALUE = 1;

    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickels;
    private int numberOfPennies;

    public Change(int cents) {
        this.numberOfQuarters = cents / QUARTER_VALUE;
        cents %= QUARTER_VALUE;

        this.numberOfDimes = cents / DIME_VALUE;
        cents %= DIME_VALUE;

        this.numberOfNickels = cents / NICKEL_VALUE;
        cents %= NICKEL_VALUE;

        this.numberOfPennies = cents / PENNIE_VALUE;
    }

    public int getNumberOfQuarters() {
        return numberOfQuarters;
    }

    public int getNumberOfDimes() {
        return numberOfDimes;
    }

    public int getNumberOfNickels() {
        return numberOfNickels;
    }

    public int getNumberOfPennies() {
        return numberOfPennies;
    }

    public BigDecimal getTotalValue() {
        int total = 0;
        total += numberOfQuarters * QUARTER_VALUE;
        total += numberOfDimes * DIME_VALUE;
        total += numberOfNickels * NICKEL_VALUE;
        total += numberOfPennies * PENNIE_VALUE;

        double doubleTotal = (double) total / (double) 100;

        return new BigDecimal(doubleTotal);
    }
}

