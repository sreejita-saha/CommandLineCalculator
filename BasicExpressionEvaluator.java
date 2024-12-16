import java.util.Stack; // stacks to handle the operands and the operators

public class BasicExpressionEvaluator implements ExpressionEvaluator {

    @Override // overriding methods from the ExpressionEvaluator interface
    public double evaluate(String expression) throws CalculatorException {
        expression = ExpressionHelper.handleImplicitMultiplication(expression); // handles implicit multiplication, e.g., (x)(y)
        expression = ExpressionHelper.handleConsecutiveNegativeSigns(expression); // handles consecutive negative signs, e.g., -- becomes +
        expression = ExpressionHelper.handleConsecutivePositiveSigns(expression); // handles consecutive positive signs, e.g., ++ becomes +

        return evaluateExpression(expression); // calls method to compute the result after handling the special cases
    }

    private double evaluateExpression(String expression) throws CalculatorException {
        /// <summary>
        /// This method evaluates the mathematical expression step by step, handling numbers, operators, and parentheses.
        /// It uses two stacks: one for operands (numbers) and one for operators.
        /// </summary>

        Stack<Double> operandStack = new Stack<>(); // creating a stack to store operands (numbers)
        Stack<Character> operatorStack = new Stack<>(); // stack to store the operators (+, -, *, /, etc.)

        int i = 0; // To track the current position in the expression string
        while (i < expression.length()) { // loop through the entire expression
            char current = expression.charAt(i); // get current character

            // Handle negative numbers (like -2, or negative numbers after operators or parentheses)
            if (current == '-' && (i == 0 || expression.charAt(i - 1) == '(' || OperatorHelper.isOperator(expression.charAt(i - 1)))) {
                String number = ExpressionHelper.parseNumber(expression, i); // parse the negative number starting from index i
                operandStack.push(Double.parseDouble(number)); // push the parsed number onto the operand stack
                i += number.length(); // move the index forward by the length of the number (could be more than one character, e.g., -34)
                continue; // skip the rest of the loop and continue to the next iteration
            }

            // Handle regular numbers (positive numbers and decimals)
            if (Character.isDigit(current) || current == '.') {
                String number = ExpressionHelper.parseNumber(expression, i); // parse the number (handles multi-digit numbers and decimals)
                operandStack.push(Double.parseDouble(number));  // push the parsed number onto the operand stack
                i += number.length(); // move the index forward by the length of the number
            }
            // Handle opening parentheses
            else if (current == '(') {
                operatorStack.push(current); // push the opening parenthesis onto the operator stack
                i++; // move to the next character
            }
            // Handle closing parentheses
            else if (current == ')') {
                //This processes operators inside the parentheses. It performs operations until encountering the matching opening parenthesis.
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    // pop and perform operations until we encounter the opening parenthesis
                    ExpressionHelper.performOperation(operandStack, operatorStack);
                }
                if (operatorStack.isEmpty() || operatorStack.pop() != '(') { // ensure parentheses are matched properly
                    throw new CalculatorException("Mismatched parentheses."); // throw an error if parentheses do not match
                }
                i++; // move to the next character after processing parentheses
            }
            // Handle operators (like +, -, *, /, etc.)
            else if (OperatorHelper.isOperator(current)) {
                // Handle precedence by performing operations while the current operator has lower or equal precedence
                while (!operatorStack.isEmpty() && OperatorHelper.precedence(operatorStack.peek()) >= OperatorHelper.precedence(current)) {
                    ExpressionHelper.performOperation(operandStack, operatorStack); // perform the operation based on operator precedence
                }
                operatorStack.push(current); // push the current operator onto the operator stack
                i++; // move to the next character
            }
            // Handle invalid characters
            else {
                throw new CalculatorException("Invalid character in expression: " + current); // throw an error if an invalid character is encountered
            }
        }

        // Process remaining operators after the main loop
        while (!operatorStack.isEmpty()) {
            ExpressionHelper.performOperation(operandStack, operatorStack); // perform the remaining operations in the operator stack
        }

        if (operandStack.size() != 1) {
            // This block checks if there is exactly one value left in the operand stack. If not, it indicates an invalid expression.
            throw new CalculatorException("Invalid expression."); // throw an error if the expression is invalid (e.g., too many operands left)
        }

        return operandStack.pop(); // return the final result (the only value left in the operand stack)
    }
}
