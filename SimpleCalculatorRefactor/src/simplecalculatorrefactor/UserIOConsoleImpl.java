/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculatorrefactor;

import java.util.Scanner;

/**
 *
 * @author softwareguild
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner userInput = new Scanner(System.in);
    
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {

        System.out.println(prompt);
        double inputNumber = userInput.nextDouble();
        return inputNumber;

    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        double inputNumber = userInput.nextDouble();
        boolean loop = true;
        do {
            if (inputNumber < min || inputNumber > max) {
                System.out.println("Please enter a number between " + min + " and " + max);
            } else {
                loop = false;
            }

        } while (loop = true);

        return inputNumber;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float inputNumber = userInput.nextFloat();

        return inputNumber; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float readFloat(String prompt, float min, float max) {

        System.out.println(prompt);
        float inputNumber = userInput.nextFloat();
        boolean loop = true;
        do {
            if (inputNumber < min || inputNumber > max) {
                System.out.println("Please enter a number between " + min + " and " + max);
            } else {
                loop = false;
            }

        } while (loop = true);

        return inputNumber;
    }

    @Override
    public int readInt(String prompt) {

        System.out.println(prompt);
        int inputNumber = userInput.nextInt();
        return inputNumber;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int inputNumber = userInput.nextInt();
        boolean loop = true;
        do {
            if (inputNumber < min || inputNumber > max) {
                System.out.println("Please enter a number between " + min + " and " + max);
            } else {
                loop = false;
            }

        } while (loop = true);

        return inputNumber; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);

        long inputNumber = userInput.nextLong();

        return inputNumber;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        long inputNumber = userInput.nextLong();
        boolean loop = true;
        do {
            if (inputNumber < min || inputNumber > max) {
                System.out.println("Please enter a number between " + min + " and " + max);
            } else {
                loop = false;
            }

        } while (loop = true);

        return inputNumber; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);

        String inputString = userInput.nextLine();

        return inputString;
    }

}
