///<summary> Similiar to Operator Helper, it contains methods that help process the expression and parse it. </summary>

import java.util.Stack;

// helper class for working with expressions
class ExpressionHelper {

    // cleans up the expression by removing spaces, handling multiplication without the * symbol, and simplifying signs
    public static String preprocessExpression(String expression) {
        expression = expression.trim().replaceAll("\\s", "");  // remove spaces
        expression = handleImplicitMultiplication(expression);  // fix multiplication without * (like "2(3)" to "2*(3)")
        expression = simplifyConsecutiveSigns(expression);  // fix consecutive signs (like "--" to "+")
        return expression;
    }

    // changes consecutive negative/positive signs
    public static String simplifyConsecutiveSigns(String expression) {
        expression = expression.replace("--", "+");  // "--" becomes "+"
        expression = expression.replace("++", "+");  // "++" becomes "+"
        return expression;
    }

    // checks if the expression is valid and has matching parentheses
    public static void validateExpression(String expression) throws CalculatorException {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (!Character.isDigit(ch) && !OperatorHelper.isOperator(ch) && ch != '(' && ch != ')' && ch != '.' && ch != 'e') {
                throw new CalculatorException("Invalid character '" + ch + "' at index " + i);  // error for invalid character
            }
            if (ch == '(') stack.push(ch);  // open parentheses
            else if (ch == ')') {  // close parentheses
                if (stack.isEmpty()) throw new CalculatorException("Mismatched parentheses at index " + i);  // error for missing opening parentheses
                stack.pop();  // remove matching opening parentheses
            }
        }
        if (!stack.isEmpty()) throw new CalculatorException("Mismatched parentheses: missing closing parenthesis.");  // error for missing closing parentheses
    }

    // adds multiplication when a number is followed by a parentheses, like "2(3)" becomes "2*(3)"
    public static String handleImplicitMultiplication(String expression) {
        StringBuilder fixedExpression = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (i > 0 && (Character.isDigit(expression.charAt(i - 1)) || expression.charAt(i - 1) == ')') && current == '(') {
                fixedExpression.append('*');  // add * for multiplication
            }
            fixedExpression.append(current);  // add the current character
        }
        return fixedExpression.toString();  // return the fixed expression
    }

    // reads a number from the expression, handling negative and decimal numbers
    public static String parseNumber(String expression, int index) {
        StringBuilder number = new StringBuilder();
        if (expression.charAt(index) == '-') {
            number.append('-');  // if it's a negative number, add minus sign
            index++;
        }
        while (index < expression.length() && (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
            number.append(expression.charAt(index));  // add digits or decimal point
            index++;
        }
        return number.toString();  // return the number as a string
    }
}