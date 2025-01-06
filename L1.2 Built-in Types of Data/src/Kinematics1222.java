public class Kinematics1222 {
    public static void main(String[] args) {
        double x0 = Double.parseDouble(args[0]);
        double v0 = Double.parseDouble(args[1]);
        double t = Double.parseDouble(args[2]);
        double g = 9.80665;
        double x1 = x0 + v0 * t - g * Math.pow(t, 2) * 0.5;
        System.out.println("displacement x1= " + x1);
    }
}
