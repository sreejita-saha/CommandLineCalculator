import java.util.Scanner;

public class TemperatureConverter extends BaseConverter {
    private final TemperatureConversions temperatureConversions = new TemperatureConversions();
    private final Scanner input = new Scanner(System.in);


    @Override
    public void displayMenu() {
        System.out.println("Welcome to the Temperature Converter.");
        System.out.println("The following options are: \n" +
                "1. Celsius to Fahrenheit     2. Fahrenheit to Celsius\n" +
                "3. Celsius to Kelvin         4. Kelvin to Celsius\n" +
                "5. Fahrenheit to Kelvin      6. Kelvin to Fahrenheit\n" +
                "0. Exit");
    }

    @Override
    public void performConversion(int choice) {
        System.out.print("Enter the temperature: ");
        double temperature = input.nextDouble();
        double convertedTemperature = 0;

        switch (choice) {
            case 1:
                convertedTemperature = temperatureConversions.celsiusToFahrenheit(temperature);
                System.out.println(temperature + " C° to Fahrenheit is " + convertedTemperature + " °F");
                break;
            case 2:
                convertedTemperature = temperatureConversions.fahrenheitToCelsius(temperature);
                System.out.println(temperature + " °F to Celsius is " + convertedTemperature + " C°");
                break;
            case 3:
                convertedTemperature = temperatureConversions.celsiusToKelvin(temperature);
                System.out.println(temperature + " C° to Kelvin is " + convertedTemperature + " K");
                break;
            case 4:
                convertedTemperature = temperatureConversions.kelvinToCelsius(temperature);
                System.out.println(temperature + " K to Celsius is " + convertedTemperature + " C°");
                break;
            case 5:
                convertedTemperature = temperatureConversions.fahrenheitToKelvin(temperature);
                System.out.println(temperature + " °F to Kelvin is " + convertedTemperature + " K");
                break;
            case 6:
                convertedTemperature = temperatureConversions.kelvinToFahrenheit(temperature);
                System.out.println(temperature + " K to Fahrenheit is " + convertedTemperature + " °F");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}
