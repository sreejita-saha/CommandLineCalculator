import java.util.*;
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double temperatureConversion = 0;
        int temperatureOption = 0;

        System.out.println("Welcome to the Temperature Converter.");
        System.out.println("The following options are: \n" +
                "1. Celsius (C°) to Fahrenheit (°F)     2. Fahrenheit (°F) to Celsius (C°)\n" +
                "3. Celsius (C°) to Kelvin (K)          4. Kelvin (K) to Celsius (C°)\n" +
                "5. Fahrenheit (°F) to Kelvin (K)       6. Kelvin (K) to Fahrenheit (°F)");

        while (temperatureOption < 1 || temperatureOption > 6) {
            System.out.print("Select one of the following options: ");
            temperatureOption = input.nextInt();
            if (temperatureOption < 1 || temperatureOption > 6) {
                System.out.println("Please select a number between 1 and 6!");
            }
        }

        System.out.print("Enter the temperature: ");
        double temperature = input.nextDouble();
        switch(temperatureOption) {
            case 1:
                temperatureConversion = (temperature * 1.8) + 32;
                System.out.println(temperature + " C° to Fahrenheit is " + temperatureConversion + " °F");
                break;
            case 2:
                temperatureConversion = (temperature - 32) * 5/9;
                System.out.println(temperature + " °F to Celsius is " + temperatureConversion + " C°");
                break;
            case 3:
                temperatureConversion = (temperature + 273.15);
                System.out.println(temperature + " C° to Kelvin is " + temperatureConversion + " K");
                break;
            case 4:
                temperatureConversion = (temperature - 273.15);
                System.out.println(temperature + " K to Celsius is " + temperatureConversion + "C°");
                break;
            case 5:
                temperatureConversion = ((temperature - 32) * 5/9) + 273.15;
                System.out.println(temperature + " °F to Kelvin is " + temperatureConversion + " K");
                break;
            case 6:
                temperatureConversion = ((temperature - 273.15) * 9/5) + 32;
                System.out.println(temperature + " K to Fahrenheit is " + temperatureConversion + " °F");
                break;
        }
    }
}
