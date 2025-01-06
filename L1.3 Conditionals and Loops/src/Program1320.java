public class Program1320 {
    public static void main(String[] args) {
        double c = Double.parseDouble(args[0]);
        int k = Integer.parseInt(args[1]);
        double epsilon = 1.0e-15;
        double t = c;

        while (Math.abs(1.0 - c / Math.pow(t, k)) > epsilon * t) {
            double ft = Math.pow(t, k) - c;
            double ftp = k * Math.pow(t, k - 1);
            t = t - ft / ftp;
        }
        System.out.println(t);
    }
}
