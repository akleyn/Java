/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachineUI;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author softwareguild
 */
public class UserIOFileImpl implements UserIO {

    private Scanner userInput = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public void print(int msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        try {
            System.out.println(prompt);
            double inputNumber = userInput.nextDouble();
            userInput.nextLine();
            return inputNumber;
        } catch (Exception e) {
            System.out.println("Exception " + e + " thrown.");
            return 0;
        }

    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        try {
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
        } catch (Exception e) {
            System.out.println("Exception " + e + " thrown.");
            return 0;
        }
    }

    @Override
    public float readFloat(String prompt) {
        try {
            System.out.println(prompt);
            float inputNumber = userInput.nextFloat();
            userInput.nextLine();
            return inputNumber;

        } catch (Exception e) {
            System.out.println("Exception " + e + " thrown.");
            return 0;
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        try {
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

            return inputNumber;
        } catch (Exception e) {
            System.out.println("Exception " + e + " thrown.");
            return 0;
        }
    }

    @Override
    public int readInt(String prompt) {
        try {
            System.out.println(prompt);

            int inputNumber = userInput.nextInt();
            userInput.nextLine();

            return inputNumber;
        } catch (Exception e) {
            System.out.println("Exception " + e + " thrown.");
            return 0;
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        try {
            System.out.println(prompt);

            int inputNumber = userInput.nextInt();
            userInput.nextLine();
            boolean loop = true;
            do {
                if (inputNumber < min || inputNumber > max) System.out.println("Please enter a number between " + min + " and " + max);
                else loop = false;
            } while (loop);

            return inputNumber;
        } catch (Exception e) {
            System.out.println("Exception " + e + " thrown.");
            return 0;
        }
    }

    @Override
    public long readLong(String prompt) {
        try {
            System.out.println(prompt);
            long inputNumber = userInput.nextLong();
            userInput.nextLine();

            return inputNumber;
        } catch (Exception e) {
            System.out.println("Exception " + e + " thrown.");
            return 0;
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        try {
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
            return inputNumber;
        } catch (Exception e) {
            System.out.println("Exception " + e + " thrown.");
            return 0;
        }
    }

    @Override
    public String readString(String prompt) {
        try {
            System.out.println(prompt);
            String inputString = userInput.nextLine();
            if (inputString.equals("")) {
                System.out.println("Please enter a string value");
                return userInput.nextLine();
            } else {
                return inputString;
            }
        } catch (Exception e) {
            System.out.println("Exception " + e + " thrown.");
            return null;
        }
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        try {
            System.out.println(prompt);
            String line = userInput.nextLine();
            return new BigDecimal(line);
        } catch (Exception e){
            System.out.println("Exception " + e + " thrown.");
            return null;
        }
}
}
