import java.util.Random;

public class app1614 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        Random random = new Random();
        StdOut.print(n + " ");

        for (int i = 0; i < n; i++) {
            int r1 = random.nextInt(n);
            while (i == r1) {
                r1 = random.nextInt(n);
            }
            StdOut.printf("%d %d ", i, r1);
        }

        for (int i = 0; i < m - n; i++) {
            int r1 = random.nextInt(n);
            int r2 = random.nextInt(n);
            while (r1 == r2) {
                r1 = random.nextInt(n);
                r2 = random.nextInt(n);
            }
            StdOut.printf("%d %d ", r1, r2);
        }
        StdOut.println();
    }
}
