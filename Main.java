import java.awt.geom.Area;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        LengthConverter lengthConverter = new LengthConverter();
        TemperatureConverter temperatureConverter = new TemperatureConverter();
        CurrencyConverter currencyConverter = new CurrencyConverter(); // Instance of CurrencyConverter

        while (true) {
            System.out.println("Welcome to the Command Line Calculator. \nYou can choose from the following options: \n" +
                    "1. Calculator                 2. Area Calculator \n" +
                    "3. Currency Converter         4. Length Converter \n" +
                    "5. Temperature Converter      6. Tax Calculator \n" +
                    "7. Matrix Calculator          0. Exit");

            int option = input.nextInt();
            input.nextLine(); // Consume the newline character after nextInt()

            if (option < 0 || option > 7) {
                System.out.println("Invalid option, please enter a valid option.");
                continue;
            }

            switch (option) {
                case 1:
                    Calculator.displayCalculator();
                    break;
                case 2:
                    AreaCalculator.displayAreaCalculator();
                    break;
                case 3:
                    currencyConverter.runConverter();  // Run the currency converter
                    break;
                case 4:
                    lengthConverter.runConverter();  // Run the length converter
                    break;
                case 5:
                    temperatureConverter.runConverter();
                    break;
                case 6:
                    TaxCalculator.displayTaxCalculator();
                    break;
                case 7:
                    MatrixCalculator.displayMatrixCalculator();
                    break;
                case 0:
                    System.out.println("Thank you for using our Tradesmen Calculator. We hope to see you again soon. \nExiting...");
                    input.close();  // Close the scanner at the end
                    return; // Exit the program
                default:
                    System.out.println("Invalid option, please enter a valid option.");
            }
        }
    }
}
