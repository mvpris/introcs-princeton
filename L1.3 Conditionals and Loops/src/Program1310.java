public class Program1310 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            double r = Math.random();
            System.out.println(r);
            sum += r;
        }
        double avg = sum / n;
        System.out.println("Average = " + avg);
    }
}
