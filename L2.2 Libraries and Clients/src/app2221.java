public class app2221 {
    public static double[] generateArraySumToOne(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Array size must be greater than 0");
        }

        double[] array = new double[n];
        double sum = 0.0;


        // Fill the array with random values
        for (int i = 0; i < n; i++) {
            array[i] = StdRandom.uniformDouble();
            sum += array[i];
        }

        // Normalise the values to make the sum equal to 1
        for (int i = 0; i < n; i++) {
            array[i] /= sum;
        }


        return array;
    }

    public static double[][] generate2DArray(int n, int m) {
        double[][] array = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = StdRandom.uniformDouble();
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int m = Integer.parseInt(args[2]);

        double[] prob = generateArraySumToOne(p);
        double[][] x = generate2DArray(n, m);
        double[][] y = generate2DArray(n, m);

        StdArrayIO.print(prob);
        StdOut.println();
        StdArrayIO.print(x);
        StdOut.println();
        StdArrayIO.print(y);
    }
}
