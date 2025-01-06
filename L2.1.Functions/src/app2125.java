public class app2125 {
    public static int simulate(int b) {
        boolean[] a = new boolean[b];
        int people = 0;
        while (true) {
            people++;
            int r = (int) (Math.random() * b);
            if (a[r]) return people;
            a[r] = true;
        }
    }


    public static void main(String[] args) {
        int n = 1000000;
        int b = 365;
        int people = 0;

        for (int i = 0; i < n; i++) {
            people += simulate(b);
        }

        double average = (double) people / n;
        StdOut.printf("%.3f people entered until two people share a birthday\n", average);
    }
}
