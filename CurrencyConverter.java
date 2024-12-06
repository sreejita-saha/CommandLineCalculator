import java.util.Scanner;

public class CurrencyConverter {
    public static void displayCurrencyConverter() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Currency Converter.");
            System.out.println("Which Currency Conversion would you like to use today? ");
            System.out.println("1. Euro € to Pound £   2. Euro € to Dollar $");
            System.out.println("3. Pound £ to Euro €   4. Pound £ to Dollar $");
            System.out.println("5. Dollar $ to Euro €  6. Dollar $ to Pound £");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice < 1 || choice > 6) {
                System.out.println("Invalid choice. Please select a valid option.");
                continue; // Prompt the user again
            }

            System.out.print("Enter your amount: ");
            double amount = scanner.nextDouble();

            double convertedAmount = 0.0;
            switch (choice) {
                case 1:
                    convertedAmount = amount * 0.85; // Euro to Pound
                    System.out.println(amount + " Euro = " + convertedAmount + " Pound");
                    break;
                case 2:
                    convertedAmount = amount * 1.1; // Euro to Dollar
                    System.out.println(amount + " Euro = " + convertedAmount + " Dollar");
                    break;
                case 3:
                    convertedAmount = amount * 1.18; // Pound to Euro
                    System.out.println(amount + " Pound = " + convertedAmount + " Euro");
                    break;
                case 4:
                    convertedAmount = amount * 1.35; // Pound to Dollar
                    System.out.println(amount + " Pound = " + convertedAmount + " Dollar");
                    break;
                case 5:
                    convertedAmount = amount * 0.92; // Dollar to Euro
                    System.out.println(amount + " Dollar = " + convertedAmount + " Euro");
                    break;
                case 6:
                    convertedAmount = amount * 0.75; // Dollar to Pound
                    System.out.println(amount + " Dollar = " + convertedAmount + " Pound");
                    break;
            }

            // Ask if the user wants to continue
            System.out.print("Would you like to continue? (y/n): ");
            scanner.nextLine(); // Clear the buffer
            String continueChoice = scanner.nextLine().trim().toLowerCase();
            if (continueChoice.equals("n")) {
                System.out.println("Thank you for using the Currency Converter. Exiting...");
                break; // Exit the loop
            } else if (!continueChoice.equals("y")) {
                System.out.println("Invalid input. Exiting Currency Converter.");
                break; // Exit if invalid input
            }
        }
    }
}
