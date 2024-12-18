//Written by Harry Kikkers and Sreejita Saha
/// <summary> Class for the user interface for the Main Calculator.
/// A stack-based calculator evaluates mathematical expressions by using two stacks: one for operands
/// (numbers) and one for operators (such as +, -, *, /, ^). It processes the expression from left to
///  right, pushing numbers onto the operand stack and operators onto the operator stack.
/// When an operator is encountered, the calculator compares its precedence with the operator
/// at the top of the stack, performing operations if necessary to ensure the correct order of
/// operations (e.g., multiplication before addition). Parentheses are handled by pushing them onto the
///  operator stack and evaluating when a closing parenthesis is encountered. After parsing the entire
/// expression, any remaining operations are performed, and the result is found at the top of the
/// operand stack.
/// </summary>

import java.util.Scanner; // scanner to handle user input

public class Calculator {
    public static void displayCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Calculator!");

        ExpressionEvaluator evaluator = new ArithmeticExpressionEvaluator(); // creating an evaluator object using BasicExpressionEvaluator class

        while (true) { // loop for repeated user input
            System.out.println("Enter a mathematical expression (or type 'E' to quit):");
            String input = scanner.nextLine();

            //to exit
            if (input.equalsIgnoreCase("E")) {
                System.out.println("Exiting the Calculator. Goodbye! \n ");
                break;
            }

            try {
                double result = evaluator.evaluate(input); // evaluate input using evaluator
                System.out.println("Result: " + result); // display the result
            } catch (CalculatorException e) { // handle errors
                System.out.println("Error: " + e.getMessage()); // display error message
            }
        }
    }
}
