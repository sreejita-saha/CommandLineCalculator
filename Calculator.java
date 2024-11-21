import java.util.Scanner;

public class Calculator {

    private String expression;
    private int position;

    public Calculator(String expression) {
        this.expression = expression;
        this.position = 0;
    }

    // This method will start evaluating the expression
    public double evaluate() {
        return parseExpression();
    }

    // Parse the main expression (handles + and -)
    private double parseExpression() {
        double result = parseTerm();

        while (position < expression.length()) {
            char currentChar = expression.charAt(position);

            if (currentChar == '+') {
                position++; // Skip the operator
                result += parseTerm(); // Add the next term
            } else if (currentChar == '-') {
                position++; // Skip the operator
                result -= parseTerm(); // Subtract the next term
            } else {
                break;
            }
        }
        return result;
    }

    // Parse terms (handles * and /)
    private double parseTerm() {
        double result = parseFactor();

        while (position < expression.length()) {
            char currentChar = expression.charAt(position);

            if (currentChar == '*') {
                position++; // Skip the operator
                result *= parseFactor(); // Multiply by the next factor
            } else if (currentChar == '/') {
                position++; // Skip the operator
                result /= parseFactor(); // Divide by the next factor
            } else {
                break;
            }
        }
        return result;
    }

    // Parse factors (handles numbers, parentheses, and implicit multiplication)
    private double parseFactor() {
        double result = 0;

        if (position < expression.length() && expression.charAt(position) == '(') {
            position++; // Skip the '('
            result = parseExpression(); // Recursively parse the expression inside parentheses
            if (position < expression.length() && expression.charAt(position) == ')') {
                position++; // Skip the ')'
            }
        } else {
            result = parseNumber(); // Parse the number
        }

        // Handle implicit multiplication when a number is followed directly by a '('
        if (position < expression.length() && expression.charAt(position) == '(') {
            result *= parseFactor(); // Multiply by the result inside parentheses
        }

        return result;
    }

    // Parse a number (can handle integers and decimals)
    private double parseNumber() {
        StringBuilder number = new StringBuilder();
        boolean isDecimal = false;

        while (position < expression.length()) {
            char currentChar = expression.charAt(position);
            if (Character.isDigit(currentChar)) {
                number.append(currentChar);
                position++;
            } else if (currentChar == '.' && !isDecimal) {
                number.append(currentChar);
                isDecimal = true;
                position++;
            } else {
                break;
            }
        }
        return Double.parseDouble(number.toString());
    }
}