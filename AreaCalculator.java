import java.util.Scanner;
import java.util.ArrayList;

public class AreaCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Double> savedAreas = new ArrayList<>();

    public static void displayAreaCalculator() {
        while (true) {
            System.out.println("The following options are: ");
            System.out.println("1. Floor/Wall Area (Rectangle)          2. Circle Area");
            System.out.println("3. Sector of a Circle Area              4. Triangle Area");
            System.out.println("5. Trapezoid Area                       6. Parallelogram Area");
            System.out.println("7. Recall Saved Areas                   8. Add All Saved Areas");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Rectangle
                    System.out.print("Enter the length (in meters): ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter the width (in meters): ");
                    double width = scanner.nextDouble();
                    double area = length * width;
                    saveAreaPrompt(area);
                    break;

                case 2: // Circle
                    System.out.print("Enter the radius (in meters): ");
                    double radius = scanner.nextDouble();
                    area = Math.PI * radius * radius;
                    saveAreaPrompt(area);
                    break;

                case 3: // Sector of a Circle
                    System.out.print("Enter the radius (in meters): ");
                    double sectorRadius = scanner.nextDouble();
                    System.out.print("Enter the angle (in degrees): ");
                    double angle = scanner.nextDouble();
                    area = (Math.PI * Math.pow(sectorRadius, 2) * angle) / 360;
                    saveAreaPrompt(area);
                    break;

                case 4: // Triangle
                    System.out.print("Enter the base (in meters): ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the height (in meters): ");
                    double height = scanner.nextDouble();
                    area = 0.5 * base * height;
                    saveAreaPrompt(area);
                    break;

                case 5: // Trapezoid
                    System.out.print("Enter the first base length (in meters): ");
                    double base1 = scanner.nextDouble();
                    System.out.print("Enter the second base length (in meters): ");
                    double base2 = scanner.nextDouble();
                    System.out.print("Enter the height (in meters): ");
                    double trapezoidHeight = scanner.nextDouble();
                    area = 0.5 * (base1 + base2) * trapezoidHeight;
                    saveAreaPrompt(area);
                    break;

                case 6: // Parallelogram
                    System.out.print("Enter the base length (in meters): ");
                    double parallelogramBase = scanner.nextDouble();
                    System.out.print("Enter the height (in meters): ");
                    double parallelogramHeight = scanner.nextDouble();
                    area = parallelogramBase * parallelogramHeight;
                    saveAreaPrompt(area);
                    break;

                case 7: // Recall and show Saved Areas
                    if (savedAreas.isEmpty()) {
                        System.out.println("No areas saved yet.");
                    } else {
                        System.out.println("Saved areas:");
                        for (int i = 0; i < savedAreas.size(); i++) {
                            System.out.printf("%d. %.2f square meters%n", i + 1, savedAreas.get(i));
                        }
                    }
                    break;

                case 8: // Add All Saved Areas
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

                case 0:
                    System.out.println("Exiting Area Calculator...");
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void saveAreaPrompt(double area) {
        System.out.println("The calculated area is: " + area + " square meters.");

        while (true) {
            System.out.print("Do you want to save this area for future use? (y/n): ");
            String saveChoice = scanner.next().trim().toLowerCase();
            /* trim(). gets rid of any whitespaces
            toLowerCase() turns input into lowercase so Y and y can be used.
             */

            if (saveChoice.equals("y")) {
                savedAreas.add(area);
                System.out.println("Area saved for future use.");
                break;
            } else if (saveChoice.equals("n")) {
                System.out.println("Area was not saved.");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }
}
