import java.util.Stack;

class ExpressionProcessor {
    private String expression;

    // Constructor to initialize the expression, preprocess and validate it.
    public ExpressionProcessor(String expression) throws CalculatorException {
        this.expression = preprocessExpression(expression); // preprocess the expression (trim whitespace, etc.)
        validateExpression(this.expression); // validate that the expression is correctly formatted
    }

    /* Processes the expression using the provided evaluator and
       Calls the evaluator's evaluate method to compute the result */
    public double process(ExpressionEvaluator evaluator) throws CalculatorException {
        return evaluator.evaluate(expression); // returns the evaluated result from the evaluator
    }

    private String preprocessExpression(String expression) {
        expression = expression.trim(); // trims leading and trailing spaces
        expression = expression.replaceAll("\\s", ""); // removes spaces for better parsing
        expression = expression.replaceAll("([0-9])\\(", "$1*("); // Add multiplication sign between a number and an opening parenthesis
        return expression; // returns the cleaned expression
    }

    // Validates the expression to ensure it contains valid characters and properly matched parentheses.
    private void validateExpression(String expression) throws CalculatorException {
        Stack<Character> stack = new Stack<>(); // stack used to validate parentheses
        for (int i = 0; i < expression.length(); i++) { // loop through the expression
            char ch = expression.charAt(i); // get current character in the expression
            // Check for valid characters
            if (!Character.isDigit(ch) && !OperatorHelper.isOperator(ch) && ch != '(' && ch != ')' && ch != '.' && ch != 'e') {
                throw new CalculatorException("Invalid character '" + ch + "' at index " + i); // throws error if invalid character is found
            }
            // Handle opening parentheses
            if (ch == '(') {
                stack.push(ch); // push '(' onto the stack
            }
            // Handle closing parentheses
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    throw new CalculatorException("Mismatched parentheses at index " + i); // throws error if there's no matching '('
                }
                stack.pop(); // pop matching '(' from stack
            }
        }
        // Check if any unmatched opening parentheses are left
        if (!stack.isEmpty()) {
            throw new CalculatorException("Mismatched parentheses: missing closing parenthesis."); // throw error if there are unmatched '('
        }
    }
}
