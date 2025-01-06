public class Program1417 {
    public static void main(String[] args) {
        double[][] a =
                {
                        {99.0, 85.0, 98.0, 0.0},
                        {98.0, 57.0, 79.0, 0.0},
                        {92.0, 77.0, 74.0, 0.0},
                        {94.0, 62.0, 81.0, 0.0},
                        {99.0, 94.0, 92.0, 0.0},
                        {80.0, 76.5, 67.0, 0.0},
                        {76.0, 58.5, 90.5, 0.0},
                        {92.0, 66.0, 91.0, 0.0},
                        {97.0, 70.5, 66.5, 0.0},
                        {89.0, 89.5, 81.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0}
                };
        double[] weights = {0.25, 0.25, 0.50};

        double sumWeights = 0.0;
        for (int i = 0; i < weights.length; i++) {
            sumWeights += weights[i];
        }

        for (int i = 0; i < a.length - 1; i++) {
            double sum = 0.0;
            for (int j = 0; j < a[0].length - 1; j++) {
                sum += a[i][j] * weights[j];
                a[i][a[i].length - 1] = sum / sumWeights;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
