import java.util.Scanner;

public class TileOptimizationWithInput {

    // Function to calculate waste based on width and length of tiles
    public static double calculateWaste(double tileWidth, double tileLength, double roomArea) {
        if (tileWidth <= 0 || tileLength <= 0) {
            return Double.MAX_VALUE; // Prevent invalid dimensions
        }

        double tileArea = tileWidth * tileLength;
        double numTiles = Math.ceil(roomArea / tileArea); // Total tiles needed
        double totalTileArea = numTiles * tileArea;

        return totalTileArea - roomArea; // Waste is extra material
    }

    // Gradient descent to minimize the waste function
    public static double[] minimizeWaste(double learningRate, int maxIterations, double roomArea) {
        double tileWidth = 1; // Start with initial guess
        double tileLength = 1;

        for (int i = 0; i < maxIterations; i++) {
            // Partial derivatives with respect to tileWidth and tileLength
            double waste = calculateWaste(tileWidth, tileLength, roomArea);
            double dWaste_dWidth = (calculateWaste(tileWidth + 0.01, tileLength, roomArea) - waste) / 0.01;
            double dWaste_dLength = (calculateWaste(tileWidth, tileLength + 0.01, roomArea) - waste) / 0.01;

            // Update tile dimensions
            tileWidth -= learningRate * dWaste_dWidth;
            tileLength -= learningRate * dWaste_dLength;

            // Ensure tile dimensions remain positive
            if (tileWidth <= 0 || tileLength <= 0) {
                tileWidth = Math.max(tileWidth, 0.1);
                tileLength = Math.max(tileLength, 0.1);
            }

            // Stop if changes are very small (converged)
            if (Math.abs(dWaste_dWidth) < 1e-6 && Math.abs(dWaste_dLength) < 1e-6) {
                break;
            }
        }

        return new double[]{tileWidth, tileLength};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get room area from the user
        System.out.print("Enter the room area in square meters: ");
        double roomArea = scanner.nextDouble();

        // Get gradient descent parameters from the user
        System.out.print("Enter the learning rate (e.g., 0.01): ");
        double learningRate = scanner.nextDouble();
        if (learningRate <= 0) {
            System.out.println("Learning rate must be a positive number.");
            return;
        }

        System.out.print("Enter the maximum number of iterations: ");
        int maxIterations = scanner.nextInt();
        if (maxIterations <= 0) {
            System.out.println("Iterations must be a positive integer.");
            return;
        }

        // Perform optimization
        double[] optimalDimensions = minimizeWaste(learningRate, maxIterations, roomArea);

        // Display results
        System.out.printf("Optimal Tile Width: %.2f meters%n", optimalDimensions[0]);
        System.out.printf("Optimal Tile Length: %.2f meters%n", optimalDimensions[1]);
        System.out.printf("Waste for Optimal Dimensions: %.2f square meters%n",
                calculateWaste(optimalDimensions[0], optimalDimensions[1], roomArea));
    }
}
