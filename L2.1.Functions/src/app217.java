public class app217 {
    public static double sqrt(double x) {
        double EPSILON = 1e-15;
        double t = x;
        while (Math.abs(t - x / t) > EPSILON * t)
            t = (x / t + t) / 2.0;
        return t;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println(sqrt(x));
    }
}
