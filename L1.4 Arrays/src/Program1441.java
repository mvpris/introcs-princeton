public class Program1441 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

//        Create & initialise array
        int[][] a = new int[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            a[i] = new int[i + 2];
            a[i][0] = 0;
        }
        a[1][1] = 1;

//        Build Pascal triangle array
        for (int i = 2; i < n + 1; i++) {
            for (int k = 1; k < a[i].length - 1; k++) {
                a[i][k] = a[i - 1][k] + a[i - 1][k - 1];
            }
        }

//        Print array
        System.out.println("Pascal triangle");
        for (int i = 1; i < n + 1; i++) {
            for (int k = 1; k < a[i].length - 1; k++) {
                System.out.print(a[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Binomial coefficients");

//        Create new double array
        double[][] b = new double[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            b[i] = new double[i + 2];
            b[i][0] = 0;
        }
        b[1][1] = 1;

        //        Build binomial distribution (ie binomial coefficients)
        for (int i = 2; i < n + 1; i++) {
            for (int k = 1; k < b[i].length - 1; k++) {
                b[i][k] = (b[i - 1][k] + b[i - 1][k - 1]) / 2.0;
            }
        }

//        Print array
        for (int i = 1; i < n + 1; i++) {
            for (int k = 1; k < b[i].length - 1; k++) {
                System.out.print(b[i][k] + " ");
            }
            System.out.println();
        }
    }
}
