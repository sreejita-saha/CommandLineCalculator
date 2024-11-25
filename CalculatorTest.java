import java.util.Scanner;

public class CalculatorTest {

    private String expression;
    private int position;

    public CalculatorTest(String expression) {
        this.expression = expression.replaceAll("\\s+", ""); // Remove spaces
        this.position = 0;
    }
    public double evaluate() {
        return parseExpression();
    }

    private double parseExpression() {
        double result = parseTerm();
        while (position < expression.length() && (expression.charAt(position) == '+' || expression.charAt(position) == '-')) {
            char operator = expression.charAt(position++);
            double nextTerm = parseTerm();
            result = operator == '+' ? result + nextTerm : result - nextTerm;
        }
        return result;
    }

    private double parseTerm() {
        double result = parseFactor();
        while (position < expression.length() && (expression.charAt(position) == '*' || expression.charAt(position) == '/')) {
            char operator = expression.charAt(position++);
            double nextFactor = parseFactor();
            result = operator == '*' ? result * nextFactor : result / nextFactor;
        }
        return result;
    }

    private double parseFactor() {
        if (expression.charAt(position) == '(') {
            position++; // Skip '('
            double result = parseExpression();
            position++; // Skip ')'
            return result;
        }

        return parseNumber();
    }

    private double parseNumber() {
        StringBuilder number = new StringBuilder();
        while (position < expression.length() && (Character.isDigit(expression.charAt(position)) || expression.charAt(position) == '.')) {
            number.append(expression.charAt(position++));
        }
        return Double.parseDouble(number.toString());
    }

    public static void main(String[] args) {
        String input = null;
        while (input != "Q" && input != "q") {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an expression: ");
            input = scanner.nextLine();

            Calculator calculator = new Calculator(input);
            System.out.println("Result: " + calculator.evaluate());

            if(input == "Q" && input == "q") {
                System.exit(0);
            }
        }
    }
}
