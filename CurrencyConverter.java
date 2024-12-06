import java.util.Scanner;

public class CurrencyConverter {

    public static void displayCurrencyConverter() {
        Scanner input = new Scanner(System.in);

        while (true) {  // Loop until the user chooses to exit
            System.out.println("Welcome to the Currency Converter.\nWhich Currency Conversion would you like to use today? \n" +
                    "1. Euro € to Pound £   2. Euro € to Dollar $ \n" +
                    "3. Pound £ to Euro €   4. Pound £ to Dollar $\n" +
                    "5. Dollar $ to Euro €  6. Dollar $ to Pound £");

            int currency = getValidChoice(input);  // Get the user's choice

            double inAmount;
            double conAmount;

            // Ask the user for the amount to convert
            System.out.print("Enter your amount: ");
            inAmount = input.nextDouble();

            // Consume the newline character left by nextDouble()
            input.nextLine();

            // Perform the conversion based on the user's choice
            switch (currency) {
                case 1: // Euro to Pound
                    conAmount = inAmount * 0.83;
                    System.out.printf("Your amount is: £%.2f%n", conAmount);
                    break;
                case 2: // Euro to Dollar
                    conAmount = inAmount * 1.05;
                    System.out.printf("Your amount is: $%.2f%n", conAmount);
                    break;
                case 3: // Pound to Euro
                    conAmount = inAmount * 1.2;
                    System.out.printf("Your amount is: €%.2f%n", conAmount);
                    break;
                case 4: // Pound to Dollar
                    conAmount = inAmount * 1.26;
                    System.out.printf("Your amount is: $%.2f%n", conAmount);
                    break;
                case 5: // Dollar to Euro
                    conAmount = inAmount * 0.95;
                    System.out.printf("Your amount is: €%.2f%n", conAmount);
                    break;
                case 6: // Dollar to Pound
                    conAmount = inAmount * 0.79;
                    System.out.printf("Your amount is: £%.2f%n", conAmount);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            // Ask the user if they want to continue
            System.out.print("Would you like to continue? (y/n):");
            String answer = input.next().trim().toLowerCase();

            if (answer.equals("n")) {
                System.out.println("Thank you for using the Currency Converter. Exiting...");
                return;
            } else if (!answer.equals("y")) {
                System.out.println("Invalid input. Exiting the program.");
                break;
            }
        }

        input.close();  // Close the scanner to avoid memory leaks
    }

    private static int getValidChoice(Scanner input) {
        int choice = -1;
        while (true) {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine().trim());
                if (choice >= 0 && choice <= 6) {
                    return choice;
                }
                System.out.println("Please enter a number between 0 and 6.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
