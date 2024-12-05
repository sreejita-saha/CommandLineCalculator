import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Command Line Calculator. \n You can choose from the following options \n" +
                "1. Expression Calculator      2. Area Calculator \n" +
                "3. Currency Converter         4. Length Converter \n" +
                "5. Tax Calculator             6. Temperature Converter \n");

        int choice = scanner.nextInt();

        if (choice < 1 || choice > 6) {
            System.out.println("Invalid choice, enter a valid choice.");
        }

        switch (choice) {
            case 1:
                Calculator.displayCalculator();
                break;
            case 2:
                //AreaCalculator.
                break;
            case 3:
                CurrencyConverter.displayCurrencyConverter();
                break;
            case 4:
                //LengthConvertor
                break;
            case 5:
                TaxCalculator.displayTaxCalculator();
                break;
            case 6:
                TemperatureConverter.displayTemperatureConverter();
                break;
            case 7:
                System.out.println("Exiting the program.");
                scanner.close(); // Close the scanner and exit
                return;

        }
        scanner.close();
    }
}