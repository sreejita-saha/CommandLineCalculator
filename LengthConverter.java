import java.util.*;

public class LengthConverter {

    public static void displayLengthCalculator() {
        Scanner input = new Scanner(System.in);
        double lengthConversion = 0;
        int lengthOption = 0;

        // Length Converter loop
        while (true) {
            System.out.println("Welcome to the Length Converter.");
            System.out.println("The following options are: \n" +
                    "1. Meters to Yards           2. Yards to Meters\n" +
                    "3. Kilometers to Miles       4. Miles to Kilometers\n" +
                    "5. Inches to Cm              6. Cm to Inches\n" +
                    "0. Exit");

            System.out.print("Select one of the following options: ");
            lengthOption = input.nextInt();

            // If the user chooses 0, return to the main menu
            if (lengthOption == 0) {
                System.out.println("Exiting Length Converter...");
                break;  // Exits this method, returning to the main menu
            }

            // Validate input choice
            if (lengthOption < 0 || lengthOption > 6) {
                System.out.println("Please select a number between 0 and 6!");
                continue;  // Continue the loop and ask for input again
            }

            System.out.print("Enter the length chosen: ");
            double length = input.nextDouble();

            // Perform the conversion based on the user's choice
            switch (lengthOption) {
                case 1: // Meters to Yards
                    lengthConversion = lengthConversions.metersToYards(length);
                    System.out.println(length + " meters is " + lengthConversion + " yards");
                    break;
                case 2: // Yards to Meters
                    lengthConversion = lengthConversions.yardsToMeters(length);
                    System.out.println(length + " yards is " + lengthConversion + " meters");
                    break;
                case 3: // Kilometers to Miles
                    lengthConversion = lengthConversions.kilometersToMiles(length);
                    System.out.println(length + " kilometers is " + lengthConversion + " miles");
                    break;
                case 4: // Miles to Kilometers
                    lengthConversion = lengthConversions.milesToKilometers(length);
                    System.out.println(length + " miles is " + lengthConversion + " kilometers");
                    break;
                case 5: // Inches to Centimeters
                    lengthConversion = lengthConversions.inchesToCentimeters(length);
                    System.out.println(length + " inches is " + lengthConversion + " cm");
                    break;
                case 6: // Centimeters to Inches
                    lengthConversion = lengthConversions.centimetersToInches(length);
                    System.out.println(length + " cm is " + lengthConversion + " inches");
                    break;
            }
        }
    }
}
