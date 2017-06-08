/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.ui;

import java.util.Scanner;

/**
 *
 * @author softwareguild
 */
public class UserIOFileImpl implements UserIO {

    Scanner userInput = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {

        System.out.println(prompt);
        double inputNumber = userInput.nextDouble();
        userInput.nextLine();
        return inputNumber;

    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        double inputNumber = userInput.nextDouble();
        userInput.nextLine();
        boolean loop = true;
        do {
            if (inputNumber < min || inputNumber > max) {
                System.out.println("Please enter a number between " + min + " and " + max);
            } else {
                loop = false;
            }

        } while (loop);

        return inputNumber;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float inputNumber = userInput.nextFloat();
        userInput.nextLine();

        return inputNumber; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        float inputNumber = userInput.nextFloat();
        userInput.nextLine();

        boolean loop = true;
        do {
            if (inputNumber < min || inputNumber > max) {
                System.out.println("Please enter a number between " + min + " and " + max);
            } else {
                loop = false;
            }

        } while (loop);

        return inputNumber; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int inputNumber = userInput.nextInt();
        userInput.nextLine();

        return inputNumber;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int inputNumber = userInput.nextInt();
        userInput.nextLine();
        boolean loop = true;
        do {
            if (inputNumber < min || inputNumber > max) {
                System.out.println("Please enter a number between " + min + " and " + max);

            } else {
                loop = false;

            }

        } while (loop);

        return inputNumber;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long inputNumber = userInput.nextLong();
        userInput.nextLine();

        return inputNumber; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        long inputNumber = userInput.nextLong();
        userInput.nextLine();
        boolean loop = true;
        do {
            if (inputNumber < min || inputNumber > max) {
                System.out.println("Please enter a number between " + min + " and " + max);

            } else {
                loop = false;
            }

        } while (loop);

        return inputNumber; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String inputString = userInput.nextLine();
        if(inputString.equals("")){
            System.out.println("Please enter a string value");
            String inputString2 = userInput.nextLine();
            return inputString2;
        }
        else {
        return inputString;
        }
    }
}
