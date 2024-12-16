/// <summary> Currency converter that offers multiple conversions for Euro, Dollar, Pound </summary>

import java.util.Scanner;

public class CurrencyConverter extends BaseConverter {
    private final CurrencyConversions currencyConversions = new CurrencyConversions(); // create CurrencyConversions object to perform the conversions
    private final Scanner input = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("Welcome to the Currency Converter.");
        System.out.println("The following options are: \n" +
                "1. Euro to Pound       2. Euro to Dollar\n" +
                "3. Pound to Euro       4. Pound to Dollar\n" +
                "5. Dollar to Euro      6. Dollar to Pound\n" +
                "0. Exit");
    }

    @Override
    public void performConversion(int choice) {
        System.out.print("Enter the amount: ");
        double amount = input.nextDouble();
        double convertedAmount = 0;

        switch (choice) {
            case 1: // Euro - Pound
                convertedAmount = currencyConversions.euroToPound(amount);
                System.out.println(amount + " € to Pound is " + convertedAmount + " £");
                break;
            case 2: // Euro - Dollar
                convertedAmount = currencyConversions.euroToDollar(amount);
                System.out.println(amount + " € to Dollar is " + convertedAmount + " $");
                break;
            case 3: // Pound - Euro
                convertedAmount = currencyConversions.poundToEuro(amount);
                System.out.println(amount + " £ to Euro is " + convertedAmount + " €");
                break;
            case 4: // Pound - Dollar
                convertedAmount = currencyConversions.poundToDollar(amount);
                System.out.println(amount + " £ to Dollar is " + convertedAmount + " $");
                break;
            case 5: //Pound - Dollar
                convertedAmount = currencyConversions.dollarToEuro(amount);
                System.out.println(amount + " $ to Euro is " + convertedAmount + " €");
                break;
            case 6: //Pound - Dollar
                convertedAmount = currencyConversions.dollarToPound(amount);
                System.out.println(amount + " $ to Pound is " + convertedAmount + " £");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}