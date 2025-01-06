public class Program1426 {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int count = 0;
        for (int k = 0; k < n; k++) {
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = i;
            }
            for (int i = 0; i < m; i++) {
                int r = i + (int) (Math.random() * (m - i));
                int temp = a[i];
                a[i] = a[r];
                a[r] = temp;
            }
            for (int i = 0; i < m - 1; i++) {
                if (a[i + 1] == a[i] + 1) {
                    count++;
                    break;
                }
            }
        }
        double p = (1 - (double) count / n) * 100;
        System.out.printf("%.2f percent\n", p);
    }
}
