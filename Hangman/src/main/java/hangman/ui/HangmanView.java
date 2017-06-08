/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author softwareguild
 */
public class HangmanView {

    private UserIO io;

    public HangmanView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("1. Run Program");
        io.print("2. Quit");
        return io.readInt("Please make a selection by pressing 1 or 2.", 1, 2);
    }
    
    public void printValue(String prompt){
        io.print(prompt);
    }


public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void goodbye() {
        io.print("Goodbye!");
    }

    public void exception() {
        io.print("Exception!");
    }
}
