import java.util.*;

public class TemperatureConverter {
    public static void displayTemperatureConverter() {
        TemperatureConversions temperatureConversions = new TemperatureConversions(); // creating object
        Scanner input = new Scanner(System.in);
        double temperatureConversion = 0;
        int temperatureOption = 0;
        String continueChoice;

        while (true) {
            System.out.println("Welcome to the Temperature Converter."); // lists the options available
            System.out.println("The following options are: \n" +
                    "1. Celsius (C°) to Fahrenheit (°F)     2. Fahrenheit (°F) to Celsius (C°)\n" +
                    "3. Celsius (C°) to Kelvin (K)          4. Kelvin (K) to Celsius (C°)\n" +
                    "5. Fahrenheit (°F) to Kelvin (K)       6. Kelvin (K) to Fahrenheit (°F)\n" +
                    "0. Exit");

            System.out.print("Select one of the following options: ");
            temperatureOption = input.nextInt(); // takes input from user

            // Exit condition
            if (temperatureOption == 0) {
                System.out.println("Exiting Temperature Converter...");
                break;
            }

            // Validate input choice
            if (temperatureOption < 1 || temperatureOption > 6) {
                System.out.println("Please select a number between 1 and 6!");
                continue;
            }

            // Ask for temperature value
            System.out.print("Enter the temperature: ");
            double temperature = input.nextDouble();

           // Perform the conversion based on user's choice
            switch (temperatureOption) {
                case 1: // Celsius to Fahrenheit
                    temperatureConversion = temperatureConversions.celsiusToFahrenheit(temperature);
                    System.out.println(temperature + " C° to Fahrenheit is " + temperatureConversion + " °F");
                    break;
                case 2: // Fahrenheit to Celsius
                    temperatureConversion = temperatureConversions.fahrenheitToCelsius(temperature);
                    System.out.println(temperature + " °F to Celsius is " + temperatureConversion + " C°");
                    break;
                case 3: // Celsius to Kelvin
                    temperatureConversion = temperatureConversions.celsiusToKelvin(temperature);
                    System.out.println(temperature + " C° to Kelvin is " + temperatureConversion + " K");
                    break;
                case 4: // Kelvin to Celsius
                    temperatureConversion = temperatureConversions.kelvinToCelsius(temperature);
                    System.out.println(temperature + " K to Celsius is " + temperatureConversion + " C°");
                    break;
                case 5: // Fahrenheit to Kelvin
                    temperatureConversion = temperatureConversions.fahrenheitToKelvin(temperature);
                    System.out.println(temperature + " °F to Kelvin is " + temperatureConversion + " K");
                    break;
                case 6: // Kelvin to Fahrenheit
                    temperatureConversion = temperatureConversions.kelvinToFahrenheit(temperature);
                    System.out.println(temperature + " K to Fahrenheit is " + temperatureConversion + " °F");
                    break;
            }

            System.out.print("Do you want to perform another conversion? (YES/NO): ");
            continueChoice = input.next().trim().toLowerCase();

            if (continueChoice.equalsIgnoreCase("NO")) {
                System.out.println("Exiting Temperature Converter... \n ");
                break;
            } else if (!continueChoice.equalsIgnoreCase("YES")) {
                System.out.println("Invalid input. Exiting the temperature converter.");
                break;
            }
        }
    }
}
