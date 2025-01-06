import java.util.Random;

public class Program1422try {
    public static void main(String[] args) {
        int n = 1000000;

//        Exact calculation
        int[] frequencies = new int[13];

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                frequencies[i + j]++;
            }
        }

//        Print first row: "f[i]"
        for (int i = 1; i <= 12; i++) {
            if (i > 9) System.out.print("f[" + i + "]  ");
            else System.out.print("f[" + i + "]   ");
        }
        System.out.println();

//        Print second row: f[i]
        for (int i = 1; i <= 12; i++) {
            System.out.printf("%-6d", frequencies[i]);
            System.out.print(" ");
        }
        System.out.println();

//        Exact probabilities + printing
        double[] probabilities = new double[13];

        for (int i = 1; i <= 12; i++) {
            probabilities[i] = frequencies[i] / (double) 36;
            System.out.printf("%6.4f", probabilities[i]);
            System.out.print(" ");
        }
        System.out.println();

//        Empirical frequencies
        Random random = new Random();
        int[] empiricalFreq = new int[13];

        for (int i = 0; i < n; i++) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            empiricalFreq[dice1 + dice2]++;
        }

//        Empirical probabilities + printing
        double[] empiricalProb = new double[13];

        for (int i = 1; i <= 12; i++) {
            empiricalProb[i] = empiricalFreq[i] / (double) n;
            System.out.printf("%6.4f", empiricalProb[i]);
            System.out.print(" ");
        }
        System.out.println();

//        Matching results (exact vs empirical)
        boolean match = true;
        for (int i = 1; i <= 12; i++) {
            if (empiricalProb[i] - probabilities[i] >= 0.001) {
                match = false;
                break;
            }
        }

//        Print result and n
        System.out.println("n=" + n);
        if (match) System.out.println("Empirical results match exact results to three decimal places.");
        else System.out.println("Empirical results do not match exact results to three decimal places.");
    }
}
