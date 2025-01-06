public class Program132 {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double discriminant = b * b - 4.0 * a * c;
        if (a == 0) {
            System.out.println(-c / b);
            System.out.println(-c / b);
        } else {
            if (discriminant < 0) {
                System.out.println("Discriminant is negative.");
            } else {
                double d = Math.sqrt(discriminant);
                System.out.println((-b + d) / (2.0 * a));
                System.out.println((-b - d) / (2.0 * a));
            }
        }
    }
}
