import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Tax Calculator.\nPlease enter your gross income for this year:");
        double grossInc = input.nextDouble();

        System.out.print("Enter your percentage of pension contribution: ");
        double pensionCon = input.nextDouble();

        System.out.print("Enter your tax credits:");
        double taxCred = input.nextDouble();

        double taxableInc = grossInc * ((100-pensionCon)/100);

        //standard rate at 20% on 20,000 is deducted from taxable income and a rate of 40% is applied to the balance
        double tax = (taxableInc - (20000*0.2))*0.6;

        //PRSI
        double prsi = taxableInc * 0.04;

        //USC
        double usc = 0;
                if (grossInc > 13000) {
                    if(grossInc < 12012) {
                        usc = 12012 * 0.005;
                    }
                    if(grossInc < 25760) {
                        usc = (12012 * 0.005) + (13748 * 0.02);
                    }
                    if(grossInc < 70044){
                        usc = (12012*0.005) + (13748 * 0.02) + (44284 * 0.04);
                    }
                    if(grossInc > 70044) {
                        usc = (grossInc - (12012*0.005) + (13748 * 0.02) + (44284 * 0.04)) * 0.08;
                    }
                }

          double totalTax = (tax + prsi + usc);
          double netIncome = grossInc - totalTax;

                System.out.printf("%s%d%s%d Your total tax is:" + "Your net income is:", totalTax, netIncome);

    }
}
