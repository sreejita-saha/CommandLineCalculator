public class MatrixOperations {
    public void displayMatrixResult(double[][] matrix) {
        for (int r = 0; r < matrix.length; r++ ) {          // outer loop iterates through the rows of the matrix as long as r < the number of rows in the matrix and when r increments it moves to the next row
            for (int c = 0 ; c < matrix[r].length; c++ ) {     // inner loop iterates through
                System.out.print(matrix[r][c] + " ");           // it is matrix[r] in the inner loop so it can be any type array size with differing rows and columns
            }
            System.out.println(); // prints a new line after each row
        }
    } 

    public double[][] matrixAddition(double[][] matrix1, double[][] matrix2) throws Exception {
        int rows1 = matrix1.length; // gets no. of rows in m1
        int columns1 = matrix1[0].length; // gets no. of columns in m1 from row1
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;
        // checks if the two matrices have same rows and columns
        if(rows1 != rows2 || columns1 != columns2) {
            throw new Exception("Matrices must have the same dimensions for addition to be done");
        }
        double[][] matrixAddition = new double[rows1][columns1]; // result matrix for the addition
        for (int r = 0; r < rows1; r++) {
            for(int c = 0; c < columns1; c++) {
                matrixAddition[r][c] = matrix1[r][c] + matrix2[r][c]; // adds corresponding elements from both matrices
            }
        }
        return matrixAddition;
    }

    public double[][] matrixSubtraction(double[][] matrix1, double[][] matrix2) throws Exception {
        int rows1 = matrix1.length; // gets no. of rows in m1
        int columns1 = matrix1[0].length; // gets no. of columns in m1 from row1
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;
        // checks if the two matrices have the same rows and columns
        if(rows1 != rows2 || columns1 != columns2) {
            throw new Exception("Matrices must have the same dimensions for addition to be done");
        }
        double[][] matrixAddition = new double[rows1][columns1];
        for (int r = 0; r < rows1; r++) {
            for(int c = 0; c < columns1; c++) {
                matrixAddition[r][c] = matrix1[r][c] - matrix2[r][c]; // subtracts corresponding elements
            }
        }
        return matrixAddition;
    }

    public double[][] matrixMultiplication(double[][] matrix1, double[][] matrix2) throws Exception {
        int rows1 = matrix1.length; // gets no. of rows in m1
        int columns1 = matrix1[0].length; // gets no. of columns in m1 from row1
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;
        // checks if number of columns in m1 and rows in m2 are equal
        if (columns1 != rows2) {
            System.out.println("Can't multiply matrix1 and matrix2 as the number of columns in matrix 1 " +
                    "do not equal the number of rows in matrix2");
            return null;
        }
        double[][] multipliedMatrixResult = new double[rows1][columns2]; // result matrix for the multiplication

        for (int r = 0; r < rows1; r++) { // goes through the rows
            for (int c = 0; c < columns2; c++) { // goes through the columns
                multipliedMatrixResult[r][c] = 0; // sets result matrix to 0 before calculations
                for (int p = 0; p < columns1; p++) { // multiplies the r row of m1 with the c column of m2
                    multipliedMatrixResult[r][c] += matrix1[r][p] * matrix2[p][c]; // adds the multiplication of the correct elements from m1 and m2
                }
            }
        }
        return multipliedMatrixResult;
    }

    public double[][] matrixTranspose(double[][] matrix1) {
        int rows1 = matrix1.length; // gets no. of rows in m1
        int columns1 = matrix1.length; // gets no. of columns in m1 from row1

        double[][] matrix1Transpose = new double[columns1][rows1]; // result matrix for the transposed matrix
        for(int r = 0; r < rows1; r++) { // rows
            for(int c = 0; c < columns1 ; c++) { // columns
                matrix1Transpose[c][r] = matrix1[r][c]; // swaps rows with columns to transpose m1
            }
        }
        return matrix1Transpose;
    }
}
