/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsstep4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Kleyn
 */
public class RockPaperScissorsStep4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();

        int userSelection = 0;
        int numberOfGames = 0;
        int wins = 0;
        int ties = 0;
        int losses = 0;
        int decision = 0;
        boolean playAgain = true;
        Scanner userInput = new Scanner(System.in);

        do {
            System.out.println("How many rounds of this game would you like to play?");
            numberOfGames = userInput.nextInt();
            if (numberOfGames > 10 || numberOfGames < 1) {
                System.out.println("You must enter a number between 1 and 10.");
                System.exit(0);
            }

            for (int i = 0; i < numberOfGames; i++) {
                System.out.println("Please select one of the following: ");
                System.out.println("1 = Rock, 2 = Paper, 3 = Scissors ");
                userSelection = userInput.nextInt();

                int randomChoice = getNumber(r.nextInt(3));

                if (userSelection == randomChoice) {
                    System.out.println("No winner...you tied!");
                    ties++;
                } else if (userSelection == 1 && randomChoice == 2) {
                    System.out.println("Paper wraps rock...you lose!");
                    losses++;
                } else if (userSelection == 2 && randomChoice == 1) {
                    System.out.println("Paper wraps rock...you win!");
                    wins++;
                } else if (userSelection == 3 && randomChoice == 1) {
                    System.out.println("Rock breaks scissors...you lose!");
                    losses++;
                } else if (userSelection == 1 && randomChoice == 3) {
                    System.out.println("Rock breaks scissors...you win!");
                    wins++;
                } else if (userSelection == 2 && randomChoice == 3) {
                    System.out.println("Scissors cut paper...you lose!");
                    losses++;
                } else if (userSelection == 3 && randomChoice == 2) {
                    System.out.println("Scissors cut paper...you win!");
                    wins++;
                }
                if (wins > losses) {
                    System.out.println("You won " + wins + " games, the computer won " + losses + " games, and tied " + ties + " games.");
                    System.out.println("You're the overall winner!");
                } else if (losses > wins) {
                    System.out.println("You won " + wins + " games, the computer won " + losses + " games, and tied " + ties + " games.");
                    System.out.println("The computer is the overall winner!");
                } else if (losses == wins) {
                    System.out.println("You won " + wins + " games, the computer won " + losses + " games, and tied " + ties + " games.");
                    System.out.println("You and the computer tied!");
                }

            }

            System.out.println("Would you like to play again?");
            System.out.println("1 - yes, 0 - no");
            decision = userInput.nextInt();
            if (decision == 1) {
                playAgain = true;
            } else if (decision == 0) {
                playAgain = false;
                System.out.println("Thanks for playing!");
                System.exit(0);
            }

        } while (playAgain = true);
    }
    
        public static int getNumber(int a) {
        return a + 1;
        }
}
