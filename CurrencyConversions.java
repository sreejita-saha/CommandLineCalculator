/// <summary> Methods containing rates for currency conversion </summary>

public class CurrencyConversions {

    public double euroToPound(double euro) {
        return euro * 0.85;
    }

    public double euroToDollar(double euro) {
        return euro * 1.1;
    }

    public double poundToEuro(double pound) {
        return pound * 1.18;
    }

    public double poundToDollar(double pound) {
        return pound * 1.35;
    }

    public double dollarToEuro(double dollar) {
        return dollar * 0.92;
    }

    public double dollarToPound(double dollar) {
        return dollar * 0.75;
    }
}
