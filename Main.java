import java.util.Scanner; //scanner for user input

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create a scanner to read user input

        //Creating instances of the converters
        LengthConverter lengthConverter = new LengthConverter();  // instantiate LengthConverter
        TemperatureConverter temperatureConverter = new TemperatureConverter();  // instantiate TemperatureConverter
        CurrencyConverter currencyConverter = new CurrencyConverter();  // instantiate CurrencyConverter

        while (true) {
            // displaying the main menu with options for the user
            System.out.println("Welcome to the Command Line Calculator. \nYou can choose from the following options: \n" +
                    "1. Calculator                 2. Area Calculator \n" +
                    "3. Currency Converter         4. Length Converter \n" +
                    "5. Temperature Converter      6. Tax Calculator \n" +
                    "7. Matrix Calculator          0. Exit");

            int option = input.nextInt();  // read the user's choice
            input.nextLine(); // consume the newline character after nextInt()

            // check if the input is valid
            if (option < 0 || option > 7) {
                System.out.println("Invalid option, please enter a valid option.");
                continue;  // skip the rest of the loop and show the menu again
            }

            // switch case to handle different options
            switch (option) {
                case 1:
                    Calculator.displayCalculator();  // call the Calculator's display method
                    break;
                case 2:
                    AreaCalculator.displayAreaCalculator();  // call the AreaCalculator's display method
                    break;
                case 3:
                    currencyConverter.runConverter();  // run the Currency converter
                    break;
                case 4:
                    lengthConverter.runConverter();  // run the Length converter
                    break;
                case 5:
                    temperatureConverter.runConverter();  // run the Temperature converter
                    break;
                case 6:
                    TaxCalculator.displayTaxCalculator();  // call the TaxCalculator's display method
                    break;
                case 7:
                    MatrixCalculator.displayMatrixCalculator();  // call the MatrixCalculator's display method
                    break;
                case 0:
                    // exit the program and display a message
                    System.out.println("Thank you for using our Tradesmen Calculator. We hope to see you again soon. \nExiting...");
                    input.close();  // close the scanner at the end
                    return;
                default:
                    System.out.println("Invalid option, please enter a valid option.");  // handle invalid input
            }
        }
    }
}
