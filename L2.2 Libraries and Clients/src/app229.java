public class app229 {
    public static double maxwellBoltzmann(double sigma) {
        double r1 = StdRandom.gaussian(0, sigma);
        double r2 = StdRandom.gaussian(0, sigma);
        double r3 = StdRandom.gaussian(0, sigma);

        return Math.sqrt(r1 * r1 + r2 * r2 + r3 * r3);
    }

    public static void main(String[] args) {
        double sigma = Double.parseDouble(args[0]);
        StdOut.println(maxwellBoltzmann(sigma));
    }
}
