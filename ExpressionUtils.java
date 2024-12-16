import java.util.Stack;

public class ExpressionUtils {

    public static String parseNumber(String expression, int i) {
        StringBuilder number = new StringBuilder();

        // Handle negative sign at the beginning of a number
        if (expression.charAt(i) == '-') {
            number.append('-');
            i++;
        }

        while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
            number.append(expression.charAt(i));
            i++;
        }

        return number.toString();
    }


    public static String handleImplicitMultiplication(String expression) {
        StringBuilder fixedExpression = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (i > 0 && (Character.isDigit(expression.charAt(i - 1)) || expression.charAt(i - 1) == ')') && current == '(') {
                fixedExpression.append('*');
            }
            fixedExpression.append(current);
        }
        return fixedExpression.toString();
    }

    public static String handleConsecutiveNegativeSigns(String expression) {
        return expression.replace("--", "+");
    }

    public static String handleConsecutivePositiveSigns(String expression) {
        return expression.replace("++", "+");
    }



    public static void performOperation(Stack<Double> operandStack, Stack<Character> operatorStack) throws CalculatorException {
        if (operandStack.size() < 2) {
            throw new CalculatorException("Invalid expression.");
        }

        double b = operandStack.pop();
        double a = operandStack.pop();
        char operator = operatorStack.pop();

        double result;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new CalculatorException("Division by zero.");
                }
                result = a / b;
                break;
            case '^':
                result = Math.pow(a, b);
                break;
            default:
                throw new CalculatorException("Unknown operator.");
        }

        operandStack.push(result);
    }
}
