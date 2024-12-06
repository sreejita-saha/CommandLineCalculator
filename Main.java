import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create the scanner outside the loop

        while (true) {
            System.out.println("Welcome to the Command Line Calculator. \nYou can choose from the following options: \n" +
                    "1. Expression Calculator      2. Area Calculator \n" +
                    "3. Currency Converter         4. Length Converter \n" +
                    "5. Tax Calculator             6. Temperature Converter \n" +
                    "0. Exit");

            int option = input.nextInt();
            input.nextLine(); // Consume the newline character after nextInt()

            if (option < 0 || option > 6) {
                System.out.println("Invalid option, please enter a valid option.");
                continue;
            }

            switch (option) {
                case 1:
                    Calculator.displayCalculator(input);
                    break;
                case 2:
                    AreaCalculator.displayAreaCalculator(); // Corrected 'input' to 'scanner'
                    break;
                case 3:
                    CurrencyConverter.displayCurrencyConverter();
                    break;
                case 4:
                    LengthConverter.displayLengthCalculator();
                    break;
                case 5:
                    TaxCalculator.displayTaxCalculator();
                    break;
                case 6:
                    TemperatureConverter.displayTemperatureConverter();
                    break;
                case 0:
                    System.out.println("Thank you for using our Tradesmen Calculator. We hope to see you again soon. \nExiting...");
                    input.close();  // Close the scanner at the end
                    return;
                default:
                    System.out.println("Invalid option, please enter a valid option.");
            }
        }
    }
}
