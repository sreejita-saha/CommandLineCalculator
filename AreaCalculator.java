import java.util.Scanner;
import java.util.ArrayList;

public class AreaCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Double> savedAreas = new ArrayList<>();

    //display menu method
    public static void displayAreaCalculator() {
        while (true) {
            System.out.println("The following options are: ");
            System.out.print(  "1. Floor/Wall Area (Rectangle)   2. Circle Area           3. Sector of a Circle Area \n" +
                    "4. Triangle Area                 5. Trapezoid Area        6. Parallelogram Area \n" +
                    "7. Recall Saved Areas            8. Add All Saved Areas   0. Exit \n" +
                    "Please enter dimensions in meters. If you need areas in different units you can use our Length converter \n" +
                    "Enter your choice: ");

            int choice = scanner.nextInt();

            double area;
            switch (choice) {
                case 1: // Rectangle
                    System.out.print("Enter the length (in meters): ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter the width (in meters): ");
                    double width = scanner.nextDouble();
                    area = Shapes.calculateRectangleArea(length, width);
                    saveArea(area);
                    break;

                case 2: // Circle
                    System.out.print("Enter the radius (in meters): ");
                    double radius = scanner.nextDouble();
                    area = Shapes.calculateCircleArea(radius);
                    saveArea(area);
                    break;

                case 3: // Sector of a Circle
                    System.out.print("Enter the radius (in meters): ");
                    double sectorRadius = scanner.nextDouble();
                    System.out.print("Enter the angle (in degrees): ");
                    double angle = scanner.nextDouble();
                    area = Shapes.calculateSectorArea(sectorRadius, angle);
                    saveArea(area);
                    break;

                case 4: // Triangle
                    System.out.print("Enter the base (in meters): ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the height (in meters): ");
                    double height = scanner.nextDouble();
                    area = Shapes.calculateTriangleArea(base, height);
                    saveArea(area);
                    break;

                case 5: // Trapezoid
                    System.out.print("Enter the first base length (in meters): ");
                    double base1 = scanner.nextDouble();
                    System.out.print("Enter the second base length (in meters): ");
                    double base2 = scanner.nextDouble();
                    System.out.print("Enter the height (in meters): ");
                    double trapezoidHeight = scanner.nextDouble();
                    area = Shapes.calculateTrapezoidArea(base1, base2, trapezoidHeight);
                    saveArea(area);
                    break;

                case 6: // Parallelogram
                    System.out.print("Enter the base length (in meters): ");
                    double parallelogramBase = scanner.nextDouble();
                    System.out.print("Enter the height (in meters): ");
                    double parallelogramHeight = scanner.nextDouble();
                    area = Shapes.calculateParallelogramArea(parallelogramBase, parallelogramHeight);
                    saveArea(area);
                    break;
                //shows the list of all saved areas
                case 7:
                    if (savedAreas.isEmpty()) {
                        System.out.println("No areas saved yet.");
                    } else {
                        System.out.println("Saved areas:");
                        for (int i = 0; i < savedAreas.size(); i++) {
                            System.out.printf("%d. %.2f square meters%n", i + 1, savedAreas.get(i));
                        }
                    }
                    break;
                //sums the saved areas
                case 8:
                    if (savedAreas.isEmpty()) {
                        System.out.println("No areas saved yet.");
                    } else {
                        double totalArea = 0;  // start with 0 as the total area
                        for (double savedArea : savedAreas) {  // loop through each saved area
                            totalArea += savedArea;  // add each saved area to totalArea
                        }
                        System.out.printf("The total of all saved areas is: %.2f square meters.%n", totalArea);
                    }
                    break;
                case 0:
                    System.out.println("Exiting Area Calculator...\n ");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    //method to ask and save area that is used after each minor calculation
    private static void saveArea(double area) {
        System.out.println("The calculated area is: " + area + " square meters.");

        while (true) {
            System.out.print("Do you want to save this area for future use? (y/n): ");
            String saveChoice = scanner.next().trim().toLowerCase();

            if (saveChoice.equals("y")) {
                savedAreas.add(area); //area is added to the array
                System.out.println("Area saved for future use. \n ");
                break;
            } else if (saveChoice.equals("n")) {
                System.out.println("Area was not saved. \n ");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }
}
