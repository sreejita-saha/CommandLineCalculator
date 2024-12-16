import java.util.Stack;

public class BasicExpressionEvaluator implements ExpressionEvaluator {

    @Override
    public double evaluate(String expression) throws CalculatorException {
        expression = ExpressionUtils.handleImplicitMultiplication(expression);
        expression = ExpressionUtils.handleConsecutiveNegativeSigns(expression);
        expression = ExpressionUtils.handleConsecutivePositiveSigns(expression);

        return evaluateExpression(expression);
    }

    private double evaluateExpression(String expression) throws CalculatorException {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char current = expression.charAt(i);

            // Handle negative numbers (after operators or parentheses)
            if (current == '-' && (i == 0 || expression.charAt(i - 1) == '(' || OperatorHelper.isOperator(expression.charAt(i - 1)))) {
                String number = ExpressionUtils.parseNumber(expression, i);
                operandStack.push(Double.parseDouble(number));
                i += number.length();
                continue;
            }

            // Handle numbers
            if (Character.isDigit(current) || current == '.') {
                String number = ExpressionUtils.parseNumber(expression, i);
                operandStack.push(Double.parseDouble(number));
                i += number.length();
            }
            // Handle opening parentheses
            else if (current == '(') {
                operatorStack.push(current);
                i++;
            }
            // Handle closing parentheses
            else if (current == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    ExpressionUtils.performOperation(operandStack, operatorStack);
                }
                if (operatorStack.isEmpty() || operatorStack.pop() != '(') {
                    throw new CalculatorException("Mismatched parentheses.");
                }
                i++;
            }
            // Handle operators
            else if (OperatorHelper.isOperator(current)) {
                while (!operatorStack.isEmpty() && OperatorHelper.precedence(operatorStack.peek()) >= OperatorHelper.precedence(current)) {
                    ExpressionUtils.performOperation(operandStack, operatorStack);
                }
                operatorStack.push(current);
                i++;
            }
            // Handle invalid characters
            else {
                throw new CalculatorException("Invalid character in expression: " + current);
            }
        }

        // Process remaining operators
        while (!operatorStack.isEmpty()) {
            ExpressionUtils.performOperation(operandStack, operatorStack);
        }

        if (operandStack.size() != 1) {
            throw new CalculatorException("Invalid expression.");
        }

        return operandStack.pop();
    }
}
