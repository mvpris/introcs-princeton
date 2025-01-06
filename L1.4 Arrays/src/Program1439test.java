public class Program1439test {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

//        Harmonic number
        double Hn1 = 0;
        double Hn2 = 0;
        double Hn3 = 0;
        double Hn4 = 0;
        double Hn5 = 0;
        for (int i = 1; i <= n; i++) {
            Hn1 += (double) 1 / i;
        }
        for (int i = 1; i <= n; i++) {
            Hn2 += (double) (1 / i);
        }
        for (int i = 1; i <= n; i++) {
            Hn3 += 1.0 / i;
        }
        for (int i = 1; i <= n; i++) {
            Hn4 += 1 / i;
        }
        for (int i = 1; i <= n; i++) {
            Hn5 += 1 / (double) i;
        }
        System.out.println(Hn1);
        System.out.println(Hn2);
        System.out.println(Hn3);
        System.out.println(Hn4);
        System.out.println(Hn5);
    }
}
