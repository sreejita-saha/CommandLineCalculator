import java.util.Scanner; //Importing scanner for user input

public class TaxCalculator {

    public static void displayTaxCalculator() {  //Method to call and display in the main
        Scanner input = new Scanner(System.in); //Scanner object
        String repeatCalculation; //declaring, needed for repeat option

        while (true) { //While true loop to allow user to make multiple calculations
            System.out.print("Welcome to the Tax Calculator.");
            System.out.println("Please enter your gross income for this year: ");
            double grossInc = input.nextDouble();

            System.out.print("Enter your percentage of pension contribution: ");
            double pensionCon = grossInc * (input.nextDouble() / 100);

            System.out.print("Enter your percentage of Personal Retirement Savings Account: ");
            double prsa = grossInc * (input.nextDouble() / 100);

            System.out.print("Enter your tax relief for Permanent Health Benefit contribution: ");
            double phb = grossInc * (input.nextDouble() / 100);

            System.out.print("Enter your tax credits: ");
            double taxCred = input.nextDouble();

            double taxableInc = grossInc - (pensionCon + phb + prsa);

            // Standard rate at 20% on 20,000 is deducted from taxable income and a rate of 40% is applied to the balance
            double tax = 0;

            if (taxableInc < 20000) {
                tax = taxableInc * 0.2;
            } else {
                tax = (20000 * 0.2) + (taxableInc - 20000) * 0.4;
            }

            // PRSI
            double prsi = taxableInc * 0.04;
            // Traders are usually self-employed, hence they pay 4% PRSI

            // USC
            double usc = 0;
            if (grossInc > 13000) { // USC applies only if income exceeds €13,000
                if (grossInc <= 12012) {
                    usc = grossInc * 0.005; // 0.5% on income up to €12,012
                } else if (grossInc <= 25760) {
                    usc = (12012 * 0.005) + ((grossInc - 12012) * 0.02); // 0.5% on first €12,012 + 2% on the rest
                } else if (grossInc <= 70044) {
                    usc = (12012 * 0.005) + (13748 * 0.02) + ((grossInc - 25760) * 0.04); // Add 4% band
                } else {
                    usc = (12012 * 0.005) + (13748 * 0.02) + (44284 * 0.04) + ((grossInc - 70044) * 0.08); // Add 8% band
                }
            }

            double totalTax = (tax + prsi + usc) - taxCred;
            double netIncome = grossInc - totalTax;

            System.out.printf("Your total tax is: €%.2f%n", totalTax);
            System.out.printf("Your net income is: €%.2f%n", netIncome);


            System.out.println("Would you like to calculate tax again? (y/n)");
            repeatCalculation = input.next().trim().toLowerCase();

            if (repeatCalculation.equals("n")) {
                System.out.println("Thank you for using the Tax Calculator. Exiting...");
                break;  // Exit the loop and terminate the program
            } else if (!repeatCalculation.equals("y")) {
                System.out.println("Invalid input. Exiting the program.");
                break;  // Exit if the user enters something other than "y" or "n"
            }
        }
    }
}
