package simplecalculatorrefactor;

import java.util.Scanner;

/**
 *
 * @author Kleyn
 */
public class App {

    private UserIO io = new UserIOConsoleImpl();
    private static int quantity1;
    private static int quantity2;
    private static int operation;
    private static String number;
    private static String answer;
    private SimpleCalculatorRefactor mySimpleCalculator = new SimpleCalculatorRefactor();

    public void calculateRefactor() {

       
        operation = io.readInt("Please select one of the following operations:"
                + "1- Addition, 2-Subtraction, 3-Multiplication, 4-Division, 5-exit:");
        quantity1 = io.readInt("Please enter the first quantity:");
        quantity2 = io.readInt("Please enter the second quantity:");
        calculate();
    }

    public void calculate() {
        SimpleCalculatorRefactor calculator = new SimpleCalculatorRefactor();
        answer = "The answer is:";
        switch (operation) {
            case 1:
                
                number = Integer.toString(calculator.addNumbers(quantity1, quantity2));
                io.print(answer + number);
                break;
            case 2:
                number = Integer.toString(calculator.subtractNumbers(quantity1, quantity2));
                io.print(answer + number);
                break;
            case 3:
                number = Integer.toString(calculator.multiplyNumbers(quantity1, quantity2));
                io.print(answer + number);
                break;
            case 4:
                number = Integer.toString(calculator.divideNumbers(quantity1, quantity2));
                io.print(answer + number);
                break;
            case 5:
                System.exit(0);
        }

    }
    

}
