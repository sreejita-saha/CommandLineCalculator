import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Calculator!");

        ExpressionEvaluator evaluator = new BasicExpressionEvaluator(); // Using the basic evaluator.

        while (true) {
            System.out.println("Enter a mathematical expression (or type 'exit' to quit):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the Calculator. Goodbye!");
                break;
            }

            try {
                double result = evaluator.evaluate(input);
                System.out.println("Result: " + result);
            } catch (CalculatorException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
