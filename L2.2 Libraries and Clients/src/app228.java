public class app228 {
    public static double exp(double gamma) {
        double x = StdRandom.uniformDouble();

        return -Math.log(x) / gamma;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println(exp(x));
    }
}
