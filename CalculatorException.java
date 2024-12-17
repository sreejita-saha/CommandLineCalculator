public class CalculatorException extends Exception {  // this is a custom exception class for better error handling
    public CalculatorException(String message) {  // constructor that takes a message
        super(message);  // passes the message to the parent Exception class
    }
}
