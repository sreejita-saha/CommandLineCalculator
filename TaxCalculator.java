///<summary> Tax Calculator that can compute your yearly tax according to the rules of the Irish system.</summary>

import java.util.Scanner; // scanner for user input

public class TaxCalculator {

    public static void displayTaxCalculator() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Tax Calculator.");

        //loop for repeated user inputs
        while (true) {
            // get user input with validation for gross income, pension, PRSA, PHB, and tax credits
            double grossIncome = validation(input, "Please enter your gross income for this year: ");
            double pensionCon = validation(input, "Enter your percentage of pension contribution: ") / 100;
            double prsa = validation(input, "Enter your percentage of PRSA: ") / 100;
            double phb = validation(input, "Enter your PHB contribution percentage: ") / 100;
            double taxCredits = validation(input, "Enter your tax credits: ");

            // calculate total tax and net income
            double totalTax = calculateTax(grossIncome, pensionCon, prsa, phb, taxCredits);
            double netIncome = grossIncome - totalTax;

            // display results
            System.out.printf("Your total tax is: €%.2f%n", totalTax);
            System.out.printf("Your net income is: €%.2f%n", netIncome);

            // check if user wants to continue
            if (!askContinue(input)) {
                System.out.println("Exiting Tax Calculator... \n ");
                break;
            }
        }
    }
    //method to calculate tax
    public static double calculateTax(double grossInc, double pensionCon, double prsa, double phb, double taxCred) {
        // calculate taxable income after deductions
        double taxableIncome = grossInc - (pensionCon + phb + prsa);

        //ensure it is not negative
        if (taxableIncome < 0) {
            taxableIncome = 0;
        }

        // calculate income tax
        double tax = 0;
        if (taxableIncome < 20000) {
            tax = taxableIncome * 0.2;
        } else {
            tax = (20000 * 0.2) + (taxableIncome - 20000) * 0.4;
        }

        // calculate PRSI (Pay Related Social Insurance)
        double prsi = taxableIncome * 0.04;

        // calculate USC (Universal Social Charge)
        double usc = 0;
        if (grossInc > 13000) {
            if (grossInc <= 12012) {
                usc = grossInc * 0.005;
            } else if (grossInc <= 25760) {
                usc = (12012 * 0.005) + ((grossInc - 12012) * 0.02);
            } else if (grossInc <= 70044) {
                usc = (12012 * 0.005) + (13748 * 0.02) + ((grossInc - 25760) * 0.04);
            } else {
                usc = (12012 * 0.005) + (13748 * 0.02) + (44284 * 0.04) + ((grossInc - 70044) * 0.08);
            }
        }

        // total tax liability after deducting tax credits
        double totalTax = (tax + prsi + usc) - taxCred;

        // ensure total tax is not negative
        if (totalTax < 0) {
            totalTax = 0;
        }

        return totalTax;
    }
    // Method for validation
    private static double validation(Scanner input, String prompt) {
        double value = -1;
        // keep asking for input until valid value is entered
        while (value < 0) {
            System.out.print(prompt);
            if (input.hasNextDouble()) {
                value = input.nextDouble();
                if (value < 0) {
                    System.out.println("Value cannot be negative. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next(); // consume the invalid input
            }
        }
        return value;
    }
    // Method for continue or exit prompt.
    private static boolean askContinue(Scanner input) {
        System.out.print("Do you want to perform another tax calculation? (Y/N): ");
        String continueChoice = input.next().trim().toLowerCase();

        // return true for yes, false for no
        if (continueChoice.equalsIgnoreCase("N")) {
            return false;
        } else if (!continueChoice.equalsIgnoreCase("Y")) {
            System.out.println("Invalid input. Exiting the tax calculator. \n ");
            return false;
        }
        return true;
    }
}
