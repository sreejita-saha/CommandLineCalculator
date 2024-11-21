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
        int currency = input.nextInt();

        //asking user for the amount they want to convert
        System.out.print("Enter your amount: ");
        //taking and storing the amount
        double inAmount = input.nextDouble();
        //initialise the converted amounnt
        double conAmount = 0;

        //switch statement
        private static void switchStatement; {
        switch (currency) {
            case 1:
                conAmount = inAmount * 0.83;
                System.out.println("Your amount is: £" + conAmount);
                break;
            case 2:
                conAmount = inAmount * 1.05;
                System.out.println("Your amount is: $" + conAmount);
                break;
            case 3:
                conAmount = inAmount * 1.2;
                System.out.println("Your amount is: €" + conAmount);
                break;
            case 4:
                conAmount = inAmount * 1.26;
                System.out.println("Your amount is: $" + conAmount);
                break;
            case 5:
                conAmount = inAmount * 0.95;
                System.out.println("Your amount is: €" + conAmount);
                break;
            case 6:
                conAmount = inAmount * 0.79;
                System.out.println("Your amount is: £" + conAmount);
                break;
        }
        System.out.println("Would you like to continue? Press Y for yes and N for no");
        String ans = input.next();

        if (ans == "Y" ) {


        }
    }
}
