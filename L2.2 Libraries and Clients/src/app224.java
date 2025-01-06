import java.util.Arrays;
import java.util.Objects;

public class app224 {
    public static void shuffle(double[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + StdRandom.uniformInt(n - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + StdRandom.uniformInt(n - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(String[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + StdRandom.uniformInt(n - i);
            String temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void doubleShuffleTest(double[] a) {
        int numberOfShuffles = 100000;
        int n = a.length;
        int[][] countPermutations = new int[n][n];

        for (int i = 0; i < numberOfShuffles; i++) {
            double[] copy = Arrays.copyOf(a, n);
            shuffle(copy);

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (copy[j] == a[k]) {
                        countPermutations[j][k]++;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdOut.print(countPermutations[i][j] + " ");
            }
            StdOut.println();
        }
    }

    public static void intShuffleTest(int[] a) {
        int numberOfShuffles = 100000;
        int n = a.length;
        int[][] countPermutations = new int[n][n];

        for (int i = 0; i < numberOfShuffles; i++) {
            int[] copy = Arrays.copyOf(a, n);
            shuffle(copy);

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (copy[j] == a[k]) {
                        countPermutations[j][k]++;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdOut.print(countPermutations[i][j] + " ");
            }
            StdOut.println();
        }
    }

    public static void StringShuffleTest(String[] a) {
        int numberOfShuffles = 100000;
        int n = a.length;
        int[][] countPermutations = new int[n][n];

        for (int i = 0; i < numberOfShuffles; i++) {
            String[] copy = Arrays.copyOf(a, n);
            shuffle(copy);

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (Objects.equals(copy[j], a[k])) {
                        countPermutations[j][k]++;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdOut.print(countPermutations[i][j] + " ");
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        // Test client

        // Example with doubles
        double[] doublesArray = {1.0, 2.0, 3.0, 4.0};
        doubleShuffleTest(doublesArray);
        StdOut.println();

        // Example with integers
        int[] integersArray = {1, 2, 3, 4};
        intShuffleTest(integersArray);
        StdOut.println();

        // Example with strings
        String[] stringsArray = {"apple", "banana", "cherry", "date"};
        StringShuffleTest(stringsArray);
        StdOut.println();

    }
}
