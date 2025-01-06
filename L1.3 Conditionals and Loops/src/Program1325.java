public class Program1325 {
    public static void main(String[] args) {
        int stake = Integer.parseInt(args[0]);
        int goal = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);
        double p = Double.parseDouble(args[3]);
        int bets = 0;
        int wins = 0;
        for (int t = 0; t < trials; t++) {
            for (int cash = stake; cash > 0 && cash < goal; bets++) {
                if (Math.random() < p) cash++;
                else cash--;
                if (cash == goal) wins++;
            }
        }
        System.out.println(100 * wins / trials + "% wins");
        System.out.println("Avg # bets: " + bets / trials);
    }
}
