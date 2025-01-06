public class Program1341 {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        double c = 1.0 / 6.0;
        int r1t = 0;
        double r1tt = 0.0;
        int r2t = 0;
        double r2tt = 0.0;
        int r1p = 6;
        int r2p = 12;
        for (int j = 0; j < trials; j++) {
            for (int i = 0; i < r1p; i++) {
                double r1 = Math.random();
                if (r1 < c) r1t++;
            }
            if (r1t > 0) r1tt++;
            for (int i = 0; i < r2p; i++) {
                double r2 = Math.random();
                if (r2 < c) r2t++;
            }
            if (r2t > 1) r2tt++;
        }
        double c1t = (r1tt / trials) * 100.0;
        double c2t = (r2tt / trials) * 100.0;
        System.out.println("Chance of 1/6 at least once=" + c1t + "%");
        System.out.println("Chance of 1/12 at least twice=" + c2t + "%");
        if (c1t > c2t) System.out.println("Chance of 1/6 more likely");
        else if (c2t > c1t) System.out.println("Chance of 1/12 more likely");
        else System.out.println("Equal chances");
    }
}
