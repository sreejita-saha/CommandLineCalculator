import java.util.Scanner;

public class CurrencyConverter {
    public static void displayCurrencyConverter() {
        CurrencyConversions currencyConversions = new CurrencyConversions(); // Create object for CurrencyConversions
        Scanner input = new Scanner(System.in);
        double convertedAmount = 0;
        int currencyOption = 0;
        String continueChoice;

        while (true) {
            System.out.println("Welcome to the Currency Converter.");
            System.out.println("The following options are: \n" +
                    "1. Euro (€) to Pound (£)      2. Euro (€) to Dollar ($)\n" +
                    "3. Pound (£) to Euro (€)      4. Pound (£) to Dollar ($)\n" +
                    "5. Dollar ($) to Euro (€)     6. Dollar ($) to Pound (£)\n" +
                    "0. Exit");

            System.out.print("Select one of the following options: ");
            currencyOption = input.nextInt();

            if (currencyOption == 0) {
                System.out.println("Exiting Currency Converter...");
                break;
            }

            if (currencyOption < 1 || currencyOption > 6) {
                System.out.println("Please select a number between 1 and 6!");
                continue;
            }

            System.out.print("Enter the amount: ");
            double amount = input.nextDouble();

            switch (currencyOption) {
                case 1 -> {
                    convertedAmount = currencyConversions.euroToPound(amount);
                    System.out.println(amount + " € to Pound is " + convertedAmount + " £");
                }
                case 2 -> {
                    convertedAmount = currencyConversions.euroToDollar(amount);
                    System.out.println(amount + " € to Dollar is " + convertedAmount + " $");
                }
                case 3 -> {
                    convertedAmount = currencyConversions.poundToEuro(amount);
                    System.out.println(amount + " £ to Euro is " + convertedAmount + " €");
                }
                case 4 -> {
                    convertedAmount = currencyConversions.poundToDollar(amount);
                    System.out.println(amount + " £ to Dollar is " + convertedAmount + " $");
                }
                case 5 -> {
                    convertedAmount = currencyConversions.dollarToEuro(amount);
                    System.out.println(amount + " $ to Euro is " + convertedAmount + " €");
                }
                case 6 -> {
                    convertedAmount = currencyConversions.dollarToPound(amount);
                    System.out.println(amount + " $ to Pound is " + convertedAmount + " £");
                }
            }

            System.out.print("Do you want to perform another conversion? (YES/NO): ");
            continueChoice = input.next().trim().toLowerCase();

            if (continueChoice.equalsIgnoreCase("NO")) {
                System.out.println("Exiting Currency Converter... \n");
                break;
            } else if (!continueChoice.equalsIgnoreCase("YES")) {
                System.out.println("Invalid input. Exiting the currency converter.");
                break;
            }
        }
    }
}
