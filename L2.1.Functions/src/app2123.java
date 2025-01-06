public class app2123 {
    public static int getCoupon(double n) {
        return (int) (Math.random() * n);
    }

    public static int collectCoupons(int n) {
        boolean[] isCollected = new boolean[n];
        int rare = getCoupon(n);
        int count = 0;
        int distinct = 0;
        while (distinct < n) {
            if (!isCollected[rare]) {
                count++;
                if (Math.random() < 1.0 / 1000 * n) {
                    distinct++;
                    isCollected[rare] = true;
                }
            }

            int r = getCoupon(n);
            if (r != rare) {
                count++;
                if (!isCollected[r]) {
                    distinct++;
                    isCollected[r] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = collectCoupons(n);
        StdOut.println(count);
    }
}
