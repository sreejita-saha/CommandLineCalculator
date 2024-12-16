import java.util.Stack;

public class ExpressionHelper {

    // Method to parse a number from the expression, handling negative signs
    public static String parseNumber(String expression, int i) {
        StringBuilder number = new StringBuilder();

        // handle negative sign at the beginning of a number
        if (expression.charAt(i) == '-') {
            number.append('-');  // append the negative sign
            i++;  // move to the next character
        }

        // loop to collect digits and decimal point to form a valid number
        while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
            number.append(expression.charAt(i));  // append current character to number
            i++;  // move to the next character
        }

        return number.toString();  // return the parsed number as a string
    }


    // method to handle implicit multiplication (like between a number and parentheses)
    public static String handleImplicitMultiplication(String expression) {
        StringBuilder fixedExpression = new StringBuilder();

        // iterate through the expression
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            // check if there's an implicit multiplication
            if (i > 0 && (Character.isDigit(expression.charAt(i - 1)) || expression.charAt(i - 1) == ')') && current == '(') {
                fixedExpression.append('*');  // add multiplication symbol
            }
            fixedExpression.append(current);  // append the current character
        }
        return fixedExpression.toString();  // return the modified expression
    }

    // method to handle consecutive negative signs (like '--' becomes '+')
    public static String handleConsecutiveNegativeSigns(String expression) {
        return expression.replace("--", "+");  // replace '--' with '+'
    }

    // method to handle consecutive positive signs (like '++' becomes '+')
    public static String handleConsecutivePositiveSigns(String expression) {
        return expression.replace("++", "+");  // replace '++' with '+'
    }

    // method to perform the operation between two operands
    public static void performOperation(Stack<Double> operandStack, Stack<Character> operatorStack) throws CalculatorException {
        if (operandStack.size() < 2) {
            throw new CalculatorException("Invalid expression.");  // throw exception if not enough operands
        }

        double b = operandStack.pop();  // pop second operand
        double a = operandStack.pop();  // pop first operand
        char operator = operatorStack.pop();  // pop the operator

        double result;

        // perform the operation based on the operator
        switch (operator) {
            case '+':
                result = a + b;  // addition
                break;
            case '-':
                result = a - b;  // subtraction
                break;
            case '*':
                result = a * b;  // multiplication
                break;
            case '/':
                if (b == 0) {
                    throw new CalculatorException("Division by zero.");  // throw exception for division by zero
                }
                result = a / b;  // division
                break;
            case '^':
                result = Math.pow(a, b);  // exponentiation
                break;
            default:
                throw new CalculatorException("Unknown operator.");  // throw exception for unknown operator
        }

        operandStack.push(result);  // push the result back onto the operand stack
    }
}
