import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical expression (e.g., 3 + 2 * (4 - 1)): ");
        String expression = scanner.nextLine();

        Calculator calculator = new Calculator(expression);
        try {
            double result = calculator.evaluate();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: Invalid Expression");
        }

        scanner.close();
    }
}