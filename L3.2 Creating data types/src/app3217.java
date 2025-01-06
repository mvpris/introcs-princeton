public class app3217 {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[1]);
        double delta = Math.sqrt(Math.abs(b * b - 4 * a * c));
        double re = -b / 2 * a;
        double im1 = delta / 2 * a;
        double im2 = -delta / 2 * a;
        Complex3216 x1 = new Complex3216(re, im1);
        Complex3216 x2 = new Complex3216(re, im2);
        System.out.println("x1=" + x1);
        System.out.println("x2=" + x2);
    }
}
