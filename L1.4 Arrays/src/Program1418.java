public class Program1418 {
    public static void main(String[] args) {
        double[][] a =
                {
                        {99.0, 85.0, 98.0},
                        {98.0, 57.0, 79.0},
                        {92.0, 77.0, 74.0},
                        {94.0, 62.0, 81.0},
                };

        double[][] b =
                {
                        {0.25, 0.55},
                        {0.25, 0.55},
                        {0.25, 0.55},
                };

        int row1 = a.length;
        int col1 = a[0].length;
        int row2 = b.length;
        int col2 = b[0].length;

        double[][] c = new double[row1][col2];

        if (a[0].length != b.length) {
            System.out.println("Arrays cannot be multiplied.");
            return;
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
