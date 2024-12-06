import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AreaCalculator1 {
    private static final List<Double> savedAreas = new ArrayList<>(); // Stores only user-selected areas

    public static void displayAreaCalculator() {
        Scanner input = new Scanner(System.in);  // One Scanner object for the entire method
        int choice;

        do {
            System.out.println("\nWelcome to the Advanced Area Calculator for Tradespeople.");
            System.out.println("""
                    The following options are:\s
                    1. Floor/Wall Area (Rectangle)          2. Circle Area
                    3. Triangle Area                        4. Trapezoid Area
                    5. Ellipse Area                         6. Parallelogram Area
                    7. Sector of a Circle Area              8. Recall Saved Areas
                    9. Add All Saved Areas                  0. Exit""");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();  // Consume the leftover newline character

            double area;
            switch (choice) {
                case 1: // Rectangle
                    System.out.print("Enter the length (in meters): ");
                    double length = input.nextDouble();
                    System.out.print("Enter the width (in meters): ");
                    double width = input.nextDouble();
                    area = length * width;
                    saveAreaPrompt(area, input);
                    break;

                case 2: // Circle
                    System.out.print("Enter the radius (in meters): ");
                    double radius = input.nextDouble();
                    area = Math.PI * radius * radius;
                    saveAreaPrompt(area, input);
                    break;

                case 3: // Triangle
                    System.out.print("Enter the base (in meters): ");
                    double base = input.nextDouble();
                    System.out.print("Enter the height (in meters): ");
                    double height = input.nextDouble();
                    area = 0.5 * base * height;
                    saveAreaPrompt(area, input);
                    break;

                case 4: // Trapezoid
                    System.out.print("Enter the first base length (in meters): ");
                    double base1 = input.nextDouble();
                    System.out.print("Enter the second base length (in meters): ");
                    double base2 = input.nextDouble();
                    System.out.print("Enter the height (in meters): ");
                    double trapezoidHeight = input.nextDouble();
                    area = 0.5 * (base1 + base2) * trapezoidHeight;
                    saveAreaPrompt(area, input);
                    break;

                case 5: // Ellipse
                    System.out.print("Enter the major radius (in meters): ");
                    double majorRadius = input.nextDouble();
                    System.out.print("Enter the minor radius (in meters): ");
                    double minorRadius = input.nextDouble();
                    area = Math.PI * majorRadius * minorRadius;
                    saveAreaPrompt(area, input);
                    break;

                case 6: // Parallelogram
                    System.out.print("Enter the base length (in meters): ");
                    double parallelogramBase = input.nextDouble();
                    System.out.print("Enter the height (in meters): ");
                    double parallelogramHeight = input.nextDouble();
                    area = parallelogramBase * parallelogramHeight;
                    saveAreaPrompt(area, input);
                    break;

                case 7: // Sector of a Circle
                    System.out.print("Enter the radius (in meters): ");
                    double sectorRadius = input.nextDouble();
                    System.out.print("Enter the angle (in degrees): ");
                    double angle = input.nextDouble();
                    area = (Math.PI * Math.pow(sectorRadius, 2) * angle) / 360;
                    saveAreaPrompt(area, input);
                    break;

                case 8: // Recall Saved Areas
                    if (savedAreas.isEmpty()) {
                        System.out.println("No areas saved yet.");
                    } else {
                        System.out.println("Saved areas:");
                        for (int i = 0; i < savedAreas.size(); i++) {
                            System.out.printf("%d. %.2f square meters%n", i + 1, savedAreas.get(i));
                        }
                    }
                    break;

                case 9: // Add All Saved Areas
                    if (savedAreas.isEmpty()) {
                        System.out.println("No areas saved yet.");
                    } else {
                        double totalArea = 0;
                        for (double savedArea : savedAreas) {
                            totalArea += savedArea;
                        }
                        System.out.printf("The total of all saved areas is: %.2f square meters.%n", totalArea);
                    }
                    break;

                case 0: // Exit
                    System.out.println("Exiting Area Calculator...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

        } while (choice != 0);

        input.close();  // Close the scanner once done
    }

    private static void saveAreaPrompt(double area, Scanner input) {
        System.out.printf("The calculated area is: %.2f square meters.%n", area);
        System.out.print("Do you want to save this area for future use? (y/n): ");
        String saveChoice = input.nextLine().trim().toLowerCase();
        if (saveChoice.equals("y")) {
            savedAreas.add(area);
            System.out.println("Area has been saved.");
        } else {
            System.out.println("Area was not saved.");
        }
    }
}
