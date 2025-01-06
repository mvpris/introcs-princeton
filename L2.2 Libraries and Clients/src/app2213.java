public class app2213 {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        double[][] pi = StdArrayIO.readDouble2D();
        for (int i = 0; i < trials; i++) {
            pi = Matrix.multiply(pi, pi);
        }
        StdArrayIO.print(pi);
    }
}
