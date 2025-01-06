public class Program1345 {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        int t = Integer.parseInt(args[1]);
        for (double r = 1.1; r <= 5; r += 0.1) {
            for (int i = 0; i < t; i++) {
                x = r * x * (1 - x);
            }
            System.out.println("Growth rate=" + r);
            System.out.println("Final population=" + x);
            System.out.println();
        }
    }
}
