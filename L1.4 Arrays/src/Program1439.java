public class Program1439 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = 1000000;
//        Harmonic number
        double Hn = 0;
        for (int i = 1; i <= n; i++) {
            Hn += 1.0 / i;
        }
        int expected = (int) (n * Hn);
        System.out.println("expected=\t" + expected);

//        Coupon collector
        long total = 0;
        for (int i = 0; i < trials; i++) {
            boolean[] isCollected = new boolean[n];
            int distinct = 0;
            long count = 0;
            while (distinct != n) {
                int r = (int) (Math.random() * n);
                if (!isCollected[r]) {
                    isCollected[r] = true;
                    distinct++;
                }
                count++;
            }
            total += count;
//        System.out.println("count=\t\t" + count);
        }
        long result = total / trials;
        System.out.println("result=\t\t" + result);
    }
}
