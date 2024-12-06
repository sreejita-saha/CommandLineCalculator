public class Taxpayer {
    private double grossIncome;
    private double pensionContribution;
    private double prsa;
    private double phb;
    private double taxCredits;

    // Constructor
    public Taxpayer(double grossIncome, double pensionContribution, double prsa, double phb, double taxCredits) {
        this.grossIncome = grossIncome;
        this.pensionContribution = pensionContribution;
        this.prsa = prsa;
        this.phb = phb;
        this.taxCredits = taxCredits;
    }

    // Getter methods
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
}
