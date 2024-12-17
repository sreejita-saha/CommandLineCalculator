import java.util.*;

public class MatrixCalculator {
    public static void displayMatrixCalculator() {
        Scanner input = new Scanner(System.in);
        MatrixOperations matrixOperations = new MatrixOperations();

        int rows1 = 0;
        int columns1 = 0;
        double[][] matrix1; // creating 2D array m1

        int rows2 = 0;
        int columns2 = 0;
        double[][] matrix2; // 2D array m2

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
            matrix1 = new double[rows1][columns1]; // sets m1 size to the rows and columns inputted
            numberOfM1Elements = rows1 * columns1; // number of m1 elements for when user inputs elements

            System.out.print("Enter number of rows in the second matrix: ");
            rows2 = input.nextInt();
            System.out.print("Enter number of columns in the second matrix: ");
            columns2 = input.nextInt();
            matrix2 = new double[rows2][columns2]; // sets m2 size to the rows and columns inputted 
            numberOfM2Elements = rows2 * columns2;

            System.out.print("Enter the " + numberOfM1Elements + " elements in the first matrix: "); // prompt for user 
            for (int r = 0; r < rows1; r++) { // nested loop to input the elements, outer loop for the rows 
                for (int c = 0; c < columns1; c++) { // inner loop for columns
                    matrix1[r][c] = input.nextInt(); // takes input from user and assigns it at r the row and c the column 
                }
            }

            System.out.print("Enter the " + numberOfM2Elements + " elements in the second matrix: "); // prompt for user
            for (int r = 0; r < rows2; r++) { // outer loop for rows 
                for (int c = 0; c < columns2; c++) { // inner loop for columns 
                    matrix2[r][c] = input.nextInt(); // takes input from user and assigns it at r the row and c the column 
                }
            }

            System.out.println("Matrix 1: ");
            for (int r = 0; r < rows1; r++) { // rows
                for (int c = 0; c < columns1; c++) { // columns
                    System.out.print(matrix1[r][c] + " "); // prints element at r c and leaves a space then the next element is printed 
                }
                System.out.println(); // prints row 2 on newline after row 1 is done
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
                        double[][] result = matrixOperations.matrixAddition(matrix1, matrix2); // calls matrixAddition to add m1 and m2 and stores in result matrix
                        System.out.println("Result of adding matrix1 and matrix2: ");
                        matrixOperations.displayMatrixResult(result); // calls displayMatrixResult from matrixOperatiosn to display result matrix
                    } catch (Exception e ) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        double[][] result = matrixOperations.matrixSubtraction(matrix1, matrix2); // matrixSubtraction does m1 - m2 and stores in result
                        System.out.println("Result of subtracting matrix2 from matrix1 is: ");
                        matrixOperations.displayMatrixResult(result); // displayMatrixResult displays result
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        double[][] result = matrixOperations.matrixMultiplication(matrix1, matrix2); // matrixMultiplication does m1*m2 and stores in result
                        System.out.println("Result of multiplying matrix1 and matrix2 together is: ");
                        matrixOperations.displayMatrixResult(result); // displayMatrixResult displays result
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    double[][] result = matrixOperations.matrixTranspose(matrix1); // calls matrixTranspose and transposes m1, stores in result
                    System.out.println("Transpose of matrix1 is: ");
                    matrixOperations.displayMatrixResult(result); // displayMatrixResult displays result
                    break;
            }
        }
    }
}
