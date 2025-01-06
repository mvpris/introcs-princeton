public class app2217 {
    public static double gaussianBM() {
        double v = Math.random();
        double u = Math.random();

        return Math.sin(2 * Math.PI * v) * Math.sqrt(-2 * Math.log(u));
    }

    public static double gaussianM() {
        double r, x, y;
        do {
            x = StdRandom.uniformDouble(-1.0, 1.0);
            y = StdRandom.uniformDouble(-1.0, 1.0);
            r = x * x + y * y;
        } while (r >= 1 || r == 0);
        return x * Math.sqrt(-2 * Math.log(r) / r);
    }


    public static void main(String[] args) {
        int n = 100000000;
        for (int i = 0; i < n; i++) {
            double r = gaussianBM();
        }
    }
//      gaussianBM 5.5s < gaussianM 6.5s
}
