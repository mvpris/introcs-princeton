import java.util.Random;

public class Program1422 {
    public static void main(String[] args) {
        int n = 1000000; // Start with a small value of n and increase if needed
        int[] frequencies = new int[13];
        double[] probabilities = new double[13];

//         Exact calculation
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                frequencies[i + j]++;
            }
        }

//        Printing exact frequencies
        for (int i = 1; i <= 12; i++) {
            if (i > 9) System.out.print("f[" + i + "]  ");
            else System.out.print("f[" + i + "]   ");
        }
        System.out.println();
        for (int i = 1; i <= 12; i++) {
            System.out.printf("%-6d", frequencies[i]);
            System.out.print(" ");
        }
        System.out.println();

//        Calculate and print exact probabilities
        for (int k = 1; k <= 12; k++) {
            probabilities[k] = frequencies[k] / 36.0;
            System.out.printf("%6.4f", probabilities[k]);
            System.out.print(" ");
        }
        System.out.println();

//         Simulation
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            frequencies[dice1 + dice2]++;
        }

//         Calculate empirical probabilities
        double[] empiricalProbabilities = new double[13];
        for (int k = 1; k <= 12; k++) {
            empiricalProbabilities[k] = frequencies[k] / (double) n;
            System.out.printf("%6.4f", empiricalProbabilities[k]);
            System.out.print(" ");
        }
        System.out.println();

//         Compare empirical results with exact results
        boolean match = true;
        for (int k = 1; k <= 12; k++) {
            if (Math.abs(empiricalProbabilities[k] - probabilities[k]) >= 0.001) {
                match = false;
                break;
            }
        }

        System.out.println("n: " + n);
        if (match) {
            System.out.println("Empirical results match exact results to three decimal places.");
        } else {
            System.out.println("Empirical results do not match exact results to three decimal places.");
        }
    }
}
