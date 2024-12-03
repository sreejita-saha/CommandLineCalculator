import java.util.Scanner;
public class CurrencyConverter {
    public static void main(String[] args) {

        //public CurrencyConverter() {
        //making scanner object to read/take user input
        Scanner input = new Scanner(System.in);

        //prompting user to pick the conversions they want to do
        System.out.println("Welcome to the Currency Converter.\nWhich Currency Conversion would you like to use today? \n" +
                "1. Euro € to Pound £   2. Euro € to Dollar $ \n" +
                "3. Pound £ to Euro €   4. Pound £ to Dollar $\n" +
                "5. Dollar $ to Euro €  6. Dollar $ to Pound £");
        //taking and storing the users input
        int currencyChoice = input.nextInt();

        //to check if the choice is correct
        if (currencyChoice < 1 && currencyChoice > 6) {
            System.out.println("Please enter a valid option.");
            System.exit(0);
        }

        //asking user for the amount they want to convert
        System.out.print("Enter your amount: ");
        //taking and storing the amount
        double initialAmount = input.nextDouble();
        //initialise the converted amounnt
        double convertedAmount = 0;

        //switch statement
        //private static void switchStatement;
        {
            switch (currencyChoice) {
                case 1:
                    convertedAmount = initialAmount * 0.83;
                    System.out.println("Your amount is: £" + convertedAmount);
                    break;
                case 2:
                    convertedAmount = initialAmount * 1.05;
                    System.out.println("Your amount is: $" + convertedAmount);
                    break;
                case 3:
                    convertedAmount = initialAmount * 1.2;
                    System.out.println("Your amount is: €" + convertedAmount);
                    break;
                case 4:
                    convertedAmount = initialAmount * 1.26;
                    System.out.println("Your amount is: $" + convertedAmount);
                    break;
                case 5:
                    convertedAmount = initialAmount * 0.95;
                    System.out.println("Your amount is: €" + convertedAmount);
                    break;
                case 6:
                    convertedAmount = initialAmount * 0.79;
                    System.out.println("Your amount is: £" + convertedAmount);
                    break;
            }
        }
    }
}
