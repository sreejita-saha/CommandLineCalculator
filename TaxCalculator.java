import java.util.Scanner;

public class TaxCalculator {

    public static double calculateTax(double grossInc, double pensionCon, double prsa, double phb, double taxCred) {

        // Income Tax
        double taxableInc = grossInc - (pensionCon + phb + prsa);

        if (taxableInc < 0) {
            taxableInc = 0;
        }

        double tax = 0;
        if (taxableInc < 20000) {
            tax = taxableInc * 0.2;
        } else {
            tax = (20000 * 0.2) + (taxableInc - 20000) * 0.4;
        }

        //PRSI
        double prsi = taxableInc * 0.04;

        //usc
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

        double totalTax = (tax + prsi + usc) - taxCred;

        if (totalTax < 0) {
            totalTax = 0;
        }

        return totalTax;
    }

    public static boolean displayTaxCalculator() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Tax Calculator.");

        while (true) {
            double grossIncome = getValidDouble(input, "Please enter your gross income for this year: ");
            double pensionCon = getValidDouble(input, "Enter your percentage of pension contribution: ") / 100;
            double prsa = getValidDouble(input, "Enter your percentage of PRSA: ") / 100;
            double phb = getValidDouble(input, "Enter your PHB contribution percentage: ") / 100;
            double taxCredits = getValidDouble(input, "Enter your tax credits: ");

            double totalTax = calculateTax(grossIncome, pensionCon, prsa, phb, taxCredits);
            double netIncome = grossIncome - totalTax;

            System.out.printf("Your total tax is: €%.2f%n", totalTax);
            System.out.printf("Your net income is: €%.2f%n", netIncome);

            System.out.print("Do you want to perform another tax calculation? (YES/NO): ");
            String continueChoice = input.next().trim().toLowerCase();

            if (continueChoice.equalsIgnoreCase("NO")) {
                System.out.println("Exiting Tax Calculator... \n ");
                return false;
            } else if (!continueChoice.equalsIgnoreCase("YES")) {
                System.out.println("Invalid input. Exiting the tax calculator. \n ");
                return false;
            }
        }
    }

    private static double getValidDouble(Scanner input, String prompt) {
        double value = -1;
        while (value < 0) {
            System.out.print(prompt);
            if (input.hasNextDouble()) {
                value = input.nextDouble();
                if (value < 0) {
                    System.out.println("Value cannot be negative. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next();
            }
        }
        return value;
    }
}