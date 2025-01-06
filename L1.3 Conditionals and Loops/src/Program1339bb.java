public class Program1339bb {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        int n = 10;
        int i, j, fac;
        double cosine = 0;
        for (i = 0; i <= n; i++) {
            fac = 1;
            for (j = 2; j <= 2 * i; j++) {
                fac *= j;
            }
            cosine += Math.pow(-1.0, i) * Math.pow(x, 2 * i) / fac;
        }
        System.out.println("cos(" + (int) x + ")=" + cosine);
        System.out.println(Math.cos(x));
    }
}
