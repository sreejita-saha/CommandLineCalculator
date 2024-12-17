public interface ExpressionEvaluator {  // this is the interface for the main calculator
    double evaluate(String expression) throws CalculatorException;  // method to evaluate the expression and return a result
}
