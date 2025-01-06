public class Program1431b {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = 0;

        for (int i = 2; i <= n; i++) {
            int j;
            for (j = 2; j < i; j++)
                if (i % j == 0) break;
            if (j > i / j) count++;
        }

        System.out.println(count);
    }
}
