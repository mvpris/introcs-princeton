public class Program1431 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = 0;

        boolean[] a = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            a[i] = true;
        }

        for (int i = 2; i <= n / i; i++) {
            if (a[i]) {
                for (int j = i; j <= n / i; j++) {
                    a[i * j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (a[i]) count++;
        }
        System.out.println(count);
    }
}
