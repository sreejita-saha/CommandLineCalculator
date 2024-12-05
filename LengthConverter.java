/*
Just did some odd length conversions
*/

import java.util.*;
public class LengthConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double lengthConversion = 0;
        int lengthOption = 0;


        System.out.println("Welcome to the Length Converter.");
        System.out.println("The following options are: \n" +
                "1. Meters to Yards           2. Yards to Meters\n" +
                "3. Kilometers to Miles       4. Miles to Kilometers\n" +
                "5. Inches to Cm              6. Cm to Inches");

        while (lengthOption < 1 || lengthOption > 6) {
            System.out.print("Select one of the following options: ");
            lengthOption = input.nextInt();
            if (lengthOption < 1 || lengthOption > 6) {
                System.out.println("Please select a number between 1 and 6!");
            }
        }

        System.out.print("Enter the length chosen: ");
        double length = input.nextDouble();
        switch(lengthOption) {
            case 1:
                lengthConversion = length * 1.09361;
                System.out.println(length + " meters is " + lengthConversion + " yards");
                break;
            case 2:
                lengthConversion = length * 0.9144;
                System.out.println(length + " yards is " + lengthConversion + " meters");
                break;
            case 3:
                lengthConversion = length * 0.621371;
                System.out.println(length + " kilometers is " + lengthConversion + " miles");
                break;
            case 4:
                lengthConversion = length * 1.60934;
                System.out.println(length + " miles is " + lengthConversion + " kilometers");
                break;
            case 5:
                lengthConversion = length * 2.54;
                System.out.println(length + " inches is " + lengthConversion + " cm");
                break;
            case 6:
                lengthConversion = length/2.54;
                System.out.println(length + " cm is " + lengthConversion + " inches");
                break;
        }
    }
}
