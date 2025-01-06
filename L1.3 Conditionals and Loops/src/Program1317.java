public class Program1317 {
    public static void main(String[] args) {
        double P = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]) / 100;
        for (int t = 0; t <= 25; t++) {
            double money = P * Math.pow(Math.E, r * t);
            System.out.println("Amount of money after " + t + " years after investing " + P + " dollars at an interest " +
                    "rate of " + r * 100 + "% = " + money + " $");
        }
    }
}
