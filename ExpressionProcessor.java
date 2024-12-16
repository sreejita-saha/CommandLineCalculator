import java.util.Stack;

class ExpressionProcessor {
    private String expression;

    public ExpressionProcessor(String expression) throws CalculatorException {
        this.expression = preprocessExpression(expression);
        validateExpression(this.expression);
    }

    public double process(ExpressionEvaluator evaluator) throws CalculatorException {
       return evaluator.evaluate(expression);
  }

    private String preprocessExpression(String expression) {
        expression = expression.trim();
        expression = expression.replace("", "");
        return expression;
    }

    private void validateExpression(String expression) throws CalculatorException {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (!Character.isDigit(ch) && !OperatorHelper.isOperator(ch) && ch != '(' && ch != ')' && ch != '.' && ch != 'e') {
                throw new CalculatorException("Invalid character '" + ch + "' at index " + i);
            }
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    throw new CalculatorException("Mismatched parentheses at index " + i);
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            throw new CalculatorException("Mismatched parentheses: missing closing parenthesis.");
        }
    }
}