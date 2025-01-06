public class ContinuousInterest1224 {
    public static void main(String[] args) {
        double t = Double.parseDouble(args[0]);
        double P = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]) / 100;
        double money = P * Math.pow(Math.E, r * t);
        System.out.println("Amount of money after " + t + " years after investing " + P + " dollars at an interest " +
                "rate of " + r + "% = " + money + " $");
    }
}
