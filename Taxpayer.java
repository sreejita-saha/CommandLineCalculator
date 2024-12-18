/// <summary>Taxpayer Class stores and manages data for Tax Calculator for encapsulation </summary>

public class Taxpayer {
    //Declaring private fields
    private double grossIncome;
    private double pensionContribution;
    private double prsa;
    private double phb;
    private double taxCredits;

    //Constructor to initialise
    public Taxpayer(double grossIncome, double pensionContribution, double prsa, double phb, double taxCredits) {
        this.grossIncome = grossIncome;
        this.pensionContribution = pensionContribution;
        this.prsa = prsa;
        this.phb = phb;
        this.taxCredits = taxCredits;
    }

    // Getters and Setters
    public double getGrossIncome() {
        return grossIncome;
    }

    public double getPensionContribution() {
        return pensionContribution;
    }

    public double getPrsa() {
        return prsa;
    }

    public double getPhb() {
        return phb;
    }

    public double getTaxCredits() {
        return taxCredits;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public void setPensionContribution(double pensionContribution) {
        this.pensionContribution = pensionContribution;
    }

    public void setPrsa(double prsa) {
        this.prsa = prsa;
    }

    public void setPhb(double phb) {
        this.phb = phb;
    }

    public void setTaxCredits(double taxCredits) {
        this.taxCredits = taxCredits;
    }
}
