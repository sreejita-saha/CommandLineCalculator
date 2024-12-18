///<summary> This class takes care of precedence and operators and helps ArithmeticExpressionEvaluator</summary>

public class OperatorHelper {
    // method to check if the character is an operator
    public static boolean isOperator(char c) {
        // return true if the character is one of the basic operators: +, -, *, /, or ^
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // method to get the precedence of the operator
    public static int precedence(char operator) {
        // return precedence based on operator: lower number = lower precedence
        switch (operator) {
            case '+':
            case '-': // addition and subtraction have lower precedence (1)
                return 1;
            case '*':
            case '/': // multiplication and division have higher precedence (2)
                return 2;
            case '^': // exponentiation has the highest precedence (3)
                return 3;
            default: // return -1 for non-operators
                return -1;
        }
    }
}
