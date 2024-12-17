import java.util.Stack;

// class that evaluates mathematical expressions
class ArithmeticExpressionEvaluator implements ExpressionEvaluator {

    @Override
    public double evaluate(String expression) throws CalculatorException {
        expression = ExpressionHelper.preprocessExpression(expression);  // prepare the expression
        ExpressionHelper.validateExpression(expression);  // check if the expression is valid
        return evaluateExpression(expression);
    }

    // method that does the actual evaluation of the expression
    private double evaluateExpression(String expression) throws CalculatorException {
        Stack<Double> operandStack = new Stack<>();  // stack for numbers
        Stack<Character> operatorStack = new Stack<>();  // stack for operators
        int i = 0;  // index to go through the expression

        while (i < expression.length()) {
            char current = expression.charAt(i);  // get the current character

            if (isNegativeSign(expression, i, current)) {
                // if it's a negative number, handle it
                String number = ExpressionHelper.parseNumber(expression, i);  // get the number
                operandStack.push(Double.parseDouble(number));  // push number to stack
                i += number.length();  // move the index forward

            } else if (Character.isDigit(current) || current == '.') {
                // if it's a number or a decimal point
                String number = ExpressionHelper.parseNumber(expression, i);  // get the number
                operandStack.push(Double.parseDouble(number));  // push number to stack
                i += number.length();  // move the index forward

            } else if (current == '(') {
                // if it's an opening parenthesis, push it to operator stack
                operatorStack.push(current);
                i++;  // move the index forward

            } else if (current == ')') {
                // if it's a closing parenthesis, handle the operations inside it
                handleClosingParenthesis(operandStack, operatorStack);
                i++;  // move the index forward

            } else if (OperatorHelper.isOperator(current)) {
                // if it's an operator, handle it
                handleOperator(operandStack, operatorStack, current);
                i++;  // move the index forward

            } else {
                // if it's an invalid character, throw an error
                throw new CalculatorException("Invalid character in expression: " + current);
            }
        }

        // after finishing the loop, perform any remaining operations
        while (!operatorStack.isEmpty()) {
            performOperation(operandStack, operatorStack);
        }

        // there should be only one result left in the stack
        if (operandStack.size() != 1) {
            throw new CalculatorException("Invalid expression.");
        }

        return operandStack.pop();  // return the final result
    }

    private boolean isNegativeSign(String expression, int i, char current) {
        // check if the character is a '-' (negative sign) and it is at the start of the expression
        // or after an opening parenthesis '(' or another operator (like +, -, *, /)
        return current == '-' && (i == 0 || expression.charAt(i - 1) == '(' || OperatorHelper.isOperator(expression.charAt(i - 1)));
    }                                                                      // Checks if the character before the minus sign is an operator

    // handle closing parentheses, perform operations until an opening parenthesis is found
    private void handleClosingParenthesis(Stack<Double> operandStack, Stack<Character> operatorStack) throws CalculatorException {
        // keep doing operations while the operator stack is not empty and the top is not a '('
        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
            // do the operation for the operators in the stack
            performOperation(operandStack, operatorStack);
        }
        if (operatorStack.isEmpty() || operatorStack.pop() != '(') {
            throw new CalculatorException("Mismatched parentheses."); // this means parentheses are not balanced
        }
    }

    // handle operators: check precedence and perform operations
    private void handleOperator(Stack<Double> operandStack, Stack<Character> operatorStack, char current) throws CalculatorException {
        // while there are operators in the stack and the precedence of the operator at the top of the stack
        // is greater than or equal to the current operator, perform the operation
        while (!operatorStack.isEmpty() && OperatorHelper.precedence(operatorStack.peek()) >= OperatorHelper.precedence(current)) {
            performOperation(operandStack, operatorStack);
        }
        // after the necessary operations are done, push the current operator to the operator stack
        operatorStack.push(current);
    }

    // perform the operation with the top two operands from the stack
    private void performOperation(Stack<Double> operandStack, Stack<Character> operatorStack) throws CalculatorException {
        if (operandStack.size() < 2) {
            throw new CalculatorException("Invalid expression.");
        }
        double b = operandStack.pop();  // get the second operand
        double a = operandStack.pop();  // get the first operand
        char operator = operatorStack.pop();  // get the operator
        double result;

        // switch statement for different operations
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
                if (b == 0) throw new CalculatorException("Division by zero.");
                result = a / b;
                break;
            case '^':
                result = Math.pow(a, b);
                break;
            default:
                throw new CalculatorException("Unknown operator.");
        }
        operandStack.push(result);  // push the result back to the stack
    }
}