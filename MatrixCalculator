import java.util.*;

public class MatrixCalculator {
    public static void displayMatrixCalculator() {
        Scanner input = new Scanner(System.in);
        MatrixOperations matrixOperations = new MatrixOperations();

        int rows1 = 0;
        int columns1 = 0;
        double[][] matrix1;

        int rows2 = 0;
        int columns2 = 0;
        double[][] matrix2;

        int matrixOption = 0;
        int numberOfM1Elements = 0;
        int numberOfM2Elements = 0;

        while (true) {
            System.out.println("Welcome to the Matrix Calculator.");
            System.out.println("Please enter matrix information first.");

            System.out.print("Enter number of rows in the first matrix: ");
            rows1 = input.nextInt();
            System.out.print("Enter number of columns in the first matrix: ");
            columns1 = input.nextInt();
            matrix1 = new double[rows1][columns1];
            numberOfM1Elements = rows1 * columns1;

            System.out.print("Enter number of rows in the second matrix: ");
            rows2 = input.nextInt();
            System.out.print("Enter number of columns in the second matrix: ");
            columns2 = input.nextInt();
            matrix2 = new double[rows2][columns2];
            numberOfM2Elements = rows2 * columns2;

            System.out.print("Enter the " + numberOfM1Elements + " elements in the first matrix: ");
            for (int r = 0; r < rows1; r++) {
                for (int c = 0; c < columns1; c++) {
                    matrix1[r][c] = input.nextInt();
                }
            }

            System.out.print("Enter the " + numberOfM2Elements + " elements in the second matrix: ");
            for (int r = 0; r < rows2; r++) {
                for (int c = 0; c < columns2; c++) {
                    matrix2[r][c] = input.nextInt();
                }
            }

            System.out.println("Matrix 1: ");
            for (int r = 0; r < rows1; r++) {
                for (int c = 0; c < columns1; c++) {
                    System.out.print(matrix1[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();

            System.out.println("Matrix 2: ");
            for (int r = 0; r < rows1; r++ ) {
                for(int c = 0; c < columns1; c++) {
                    System.out.print(matrix2[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("The following options are: \n" +
                    "1. Matrix Addition                 2. Matrix Subtraction\n" +
                    "3. Matrix Multiplication           4. Transpose Matrix\n" +
                    "0. Exit");

            System.out.print("Select one of the following options: ");
            matrixOption = input.nextInt();

            if (matrixOption == 0){
                System.out.println("Exiting Matrix Calculator...");
                break;
            }
            if (matrixOption < 1 || matrixOption > 4) {
                System.out.println("Please select a number between 1 and 4!");
                continue;
            }
            switch (matrixOption) {
                case 1:
                    try {
                        double[][] result = matrixOperations.matrixAddition(matrix1, matrix2);
                        System.out.println("Result of adding matrix1 and matrix2: ");
                        matrixOperations.displayMatrixResult(result);
                    } catch (Exception e ) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        double[][] result = matrixOperations.matrixSubtraction(matrix1, matrix2);
                        System.out.println("Result of subtracting matrix2 from matrix1 is: ");
                        matrixOperations.displayMatrixResult(result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        double[][] result = matrixOperations.matrixMultiplication(matrix1, matrix2);
                        System.out.println("Result of multiplying matrix1 and matrix2 together is: ");
                        matrixOperations.displayMatrixResult(result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    double[][] result = matrixOperations.matrixTranspose(matrix1);
                    System.out.println("Transpose of matrix1 is: ");
                    matrixOperations.displayMatrixResult(result);
                    break;
            }
        }
    }
}
