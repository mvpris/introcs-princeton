public class StockAccountNew {
    private final String name;
    private double cash;
    private int n;
    private int[] shares;
    private String[] stocks;
    private double[] prices;

    public StockAccountNew(In in, StockPrice stockPrice) { // Build data structure from specified file.
        name = in.readString();
        cash = in.readDouble();
        n = in.readInt();
        shares = new int[n];
        stocks = new String[n];
        prices = stockPrice.getPrices();
        for (int i = 0; i < n; i++) { // Process one stock.
            shares[i] = in.readInt();
            stocks[i] = in.readString();
        }
    }

    public void printReport() {
        StdOut.println(name);
        double total = cash;
        for (int i = 0; i < n; i++) {
            int amount = shares[i];
            double price = prices[i];
            total += amount * price;
            StdOut.printf("%4d %5s ", amount, stocks[i]);
            StdOut.printf("%9.2f %11.2f\n", price, amount * price);
        }
        StdOut.printf("%21s %10.2f\n", "Cash: ", cash);
        StdOut.printf("%21s %10.2f\n", "Total:", total);
    }

    public double valueOf() {
        double total = cash;
        for (int i = 0; i < n; i++) {
            total += shares[i] * prices[i];
        }
        return total;
    }

    public void save(String filename) {
        Out out = new Out(filename);
        out.println(name);
        out.println(cash);
        out.println(n);
        for (int i = 0; i < n; i++) {
            out.print(shares[i] + " " + stocks[i]);
            out.println();
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        String filenamePrices = args[1];
        In in = new In(filename);
        StockPrice stockPrice = new StockPrice(filenamePrices);
        StockAccountNew account = new StockAccountNew(in, stockPrice);
        account.printReport();
        System.out.println("TOTAL = " + account.valueOf());
        account.save(args[2]);
    }
}
