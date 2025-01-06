public class app3233 {
    public static void main(String[] args) {
        String filename = args[0];
        String filenamePrices = args[1];

        In in = new In(filename);
        StockPrice stockPrice = new StockPrice(filenamePrices);

        int n = 0;
        while (!in.isEmpty()) {
            StockAccountNew account = new StockAccountNew(in, stockPrice);
            n++;
        }
        
        StockAccountNew[] accounts = new StockAccountNew[n];
        In in2 = new In(filename);

        double[] totals = new double[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = new StockAccountNew(in2, stockPrice);
            totals[i] = accounts[i].valueOf();
        }
        double min = StdStats.min(totals);
        double max = StdStats.max(totals);

        for (int i = 0; i < n; i++) {
            if (min == totals[i]) {
                StdOut.print("Account with the lowest total value is: ");
                accounts[i].printReport();
            }
            if (max == totals[i]) {
                StdOut.print("Account with the highest total value is: ");
                accounts[i].printReport();
            }
        }
    }
}
