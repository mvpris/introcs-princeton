public class Program1346 {
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        for (long e = 1; e <= n; e++) {
            long e5 = e * e * e * e * e;
            for (long a = 1; a <= e5; a++) {
                long a5 = a * a * a * a * a;
                if (a5 > e5) break;
                for (long b = a; b <= e5; b++) {
                    long b5 = b * b * b * b * b;
                    if (a5 + b5 > e5) break;
                    for (long c = b; c <= e5; c++) {
                        long c5 = c * c * c * c * c;
                        if (a5 + b5 + c5 > e5) break;
                        for (long d = c; d <= e5; d++) {
                            long d5 = d * d * d * d * d;
                            if (a5 + b5 + c5 + d5 > e5) break;
                            if (a5 + b5 + c5 + d5 == e5) {
                                System.out.println(a + "^5+" + b + "^5+" + c + "^5+" + d + "^5=" + e + "^5");
                            }
                        }
                    }
                }
            }
        }
    }
}
