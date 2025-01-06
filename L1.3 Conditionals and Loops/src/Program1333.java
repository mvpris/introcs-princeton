public class Program1333 {
    public static void main(String[] args) {
        double x;
        double y;
        do { // Scale x and y to be random in (-1, 1).
            x = 2.0 * Math.random() - 1.0;
            y = 2.0 * Math.random() - 1.0;
        } while (x * x + y * y > 1.0);
        System.out.println("x,y=(" + x + "," + y + ")");
        double var = 1 - Math.pow(x, 2) - Math.pow(y, 2);
        double a = 2 * x * Math.sqrt(var);
        double b = 2 * Math.sqrt(var);
        double c = 1 - 2 * (Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("a,b,c=(" + a + "," + b + "," + c + ")");
    }
}
