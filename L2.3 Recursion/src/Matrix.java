public class Matrix {
    // Method to calculate the dot product of two vectors
    public static double dot(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Vectors must have the same length");
        }

        double result = 0.0;

        // Check if the vectors have the same length
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }

        return result;
    }

    // Method to calculate the matrix-matrix product
    public static double[][] multiply(double[][] a, double[][] b) {
        int numRowsA = a.length;
        int numColsA = a[0].length;
        int numRowsB = b.length;
        int numColsB = b[0].length;

        // Check if the matrices can be multiplied
        if (numColsA != numRowsB) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }

        // Initialize the result matrix
        double[][] result = new double[numRowsA][numColsB];

        // Perform matrix multiplication
        for (int i = 0; i < numRowsA; i++) {
            for (int j = 0; j < numColsB; j++) {
                for (int k = 0; k < numColsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    // Method to calculate the transpose of a matrix
    public static double[][] transpose(double[][] a) {
        int numRows = a.length;
        int numCols = a[0].length;

        // Initialize the transposed matrix
        double[][] result = new double[numCols][numRows];

        // Perform matrix transpose
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result[j][i] = a[i][j];
            }
        }

        return result;
    }

    // Method to calculate the matrix-vector product
    public static double[] multiply(double[][] a, double[] x) {
        int numRows = a.length;
        int numCols = a[0].length;

        // Check if the number of columns in the matrix is equal to the length of the vector
        if (numCols != x.length) {
            throw new IllegalArgumentException("Number of columns in the matrix must be equal to the length of the vector");
        }

        // Initialize the result vector
        double[] result = new double[numRows];

        // Perform matrix-vector multiplication
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result[i] += a[i][j] * x[j];
            }
        }

        return result;
    }

    // Method to calculate the vector-matrix product
    public static double[] multiply(double[] x, double[][] a) {
        int numRows = a.length;
        int numCols = a[0].length;

        // Check if the length of the vector is equal to the number of rows in the matrix
        if (x.length != numRows) {
            throw new IllegalArgumentException("Length of the vector must be equal to the number of rows in the matrix");
        }

        // Initialize the result vector
        double[] result = new double[numCols];

        // Perform vector-matrix multiplication
        for (int j = 0; j < numCols; j++) {
            for (int i = 0; i < numRows; i++) {
                result[j] += x[i] * a[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        double[][] p = StdArrayIO.readDouble2D();
        double[] ranks = new double[p.length];
        ranks[0] = 1.0;
        for (int t = 0; t < trials; t++)
            ranks = Matrix.multiply(ranks, p);
        StdArrayIO.print(ranks);
    }
}
