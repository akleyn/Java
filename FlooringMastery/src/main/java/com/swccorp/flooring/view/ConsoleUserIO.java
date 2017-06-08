package com.swccorp.flooring.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUserIO implements UserIO {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private Scanner in = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return readInt();
    }

    private int readInt() {
        int value;
        while (true) {
            try {
                value = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                print("Incorrect input. Please enter an integer.");
                in.nextLine();
            }
        }
        in.nextLine();
        return value;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt();
            if (value < min || value > max) {
                print("Please enter a value between " + min + " and " + max);
            } else {
                return value;
            }
        }
    }

    @Override
    public int readInt(String prompt, int defaultValue) {
        System.out.println(prompt + " [" + defaultValue + "]");
        while (true) {
            try {
                String value = in.nextLine().trim();
                if (value.isEmpty()) {
                    return defaultValue;
                } else {
                    return Integer.parseInt(value);
                }
            } catch (NumberFormatException e) {
                print("Incorrect input. Please enter an integer.");
            }
        }
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                return in.nextBigDecimal();
            } catch (InputMismatchException e) {
                print("Incorrect input. Please enter a decimal.");
                in.nextLine();
            }
        }
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal defaultValue) {
        System.out.println(prompt + " [" + defaultValue + "]");
        while (true) {
            try {
                String value = in.nextLine().trim();
                if (value.isEmpty()) {
                    return defaultValue;
                } else {
                    return new BigDecimal(value);
                }
            } catch (NumberFormatException e) {
                print("Incorrect input. Please enter a decimal value.");
            }
        }
    }

    @Override
    public String readString() {
        return in.nextLine().trim();
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return in.nextLine().trim();
    }

    @Override
    public String readString(String prompt, String defaultValue) {
        System.out.println(prompt + " [" + defaultValue + "]");
        String value = in.nextLine().trim();
        if (value.isEmpty()) {
            return defaultValue;
        } else {
            return value;
        }
    }

    @Override
    public LocalDate readDate(String prompt) {
        print(prompt);
        while (true) {
            try {
                String string = readString();
                return LocalDate.parse(string, DATE_FORMAT);
            } catch (DateTimeParseException e) {
                print("Incorrect date format. Expected MM/DD/YYYY");
            }
        }
    }

    @Override
    public boolean readYesNo() {
        while (true) {
            String line = in.nextLine().toLowerCase();
            if (line.isEmpty()) {
                continue;
            }
            switch (line) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    print("Invalid input. Enter Y or N");
                    break;
            }
        }
    }
}
