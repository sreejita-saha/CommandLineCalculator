import java.util.Scanner;

public class LengthConverter extends BaseConverter {
    private final Scanner input = new Scanner(System.in);  // Initialize the scanner
    private final LengthConversions lengthConversions = new LengthConversions();  // Create an instance of LengthConversions

    @Override
    public void displayMenu() {
        System.out.println("Welcome to the Length Converter.");
        System.out.println("Select one of the following options: \n" +
                "1. Meters to Yards   2. Yards to Meters\n" +
                "3. Kilometers to Miles   4. Miles to Kilometers\n" +
                "5. Inches to Centimeters   6. Centimeters to Inches\n" +
                "0. Exit");
    }

    @Override
    public void performConversion(int lengthOption) {
        System.out.print("Enter the length: ");
        double length = input.nextDouble();
        double lengthConversion = 0;

        if (lengthOption < 0 || lengthOption > 6) {
            System.out.println("Please select a number between 0 and 6!");
            return;  // Exit the method if the option is invalid
        }

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
            case 0: // Exit
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid option selected.");
        }
    }
}
