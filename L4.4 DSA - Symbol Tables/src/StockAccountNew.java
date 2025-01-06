import java.util.Map;
import java.util.TreeMap;

public class StockAccountNew {
    private final String name;
    private double cash;
    private int n;
    private int[] shares;
    private String[] stocks;
    private double[] prices;
    private final TreeMap<String, Integer> sharesMap;

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
        sharesMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            sharesMap.put(stocks[i], shares[i]);
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
        StdOut.printf("%20s %11.2f\n", "Total:", total);
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

    public void buy(int amount, String symbol) {
        if (sharesMap.containsKey(symbol)) {
            sharesMap.put(symbol, sharesMap.get(symbol) + amount);
            updateBoughtStocks(false);
        } else {
            sharesMap.put(symbol, amount);
            n++;
            updateBoughtStocks(true);
        }
    }

    private void updateBoughtStocks(boolean stocksModified) {
        if (stocksModified) {
            int[] sharesNew = new int[n];
            String[] stocksNew = new String[n];
            int i = 0;
            for (Map.Entry<String, Integer> entry : sharesMap.entrySet()) {
                sharesNew[i] = entry.getValue();
                stocksNew[i] = entry.getKey();
                i++;
            }
            shares = sharesNew;
            stocks = stocksNew;
        } else {
            int i = 0;
            for (Map.Entry<String, Integer> entry : sharesMap.entrySet()) {
                shares[i] = entry.getValue();
                stocks[i] = entry.getKey();
                i++;
            }
        }
    }

    public void sell(int amount, String symbol) {
        if (sharesMap.containsKey(symbol)) {
            if (amount < sharesMap.get(symbol)) {
                sharesMap.put(symbol, sharesMap.get(symbol) - amount);
                updateSoldStocks(false);
            } else if (amount == sharesMap.get(symbol)) {
                sharesMap.remove(symbol);
                n--;
                updateSoldStocks(true);
            } else throw new RuntimeException("Amount of stock to sell is larger than the amount of owned stock");
        } else throw new RuntimeException("Stock to sell is not owned");
    }

    private void updateSoldStocks(boolean stocksModified) {
        if (stocksModified) {
            int[] sharesNew = new int[n];
            String[] stocksNew = new String[n];
            int i = 0;
            for (Map.Entry<String, Integer> entry : sharesMap.entrySet()) {
                sharesNew[i] = entry.getValue();
                stocksNew[i] = entry.getKey();
                i++;
            }
            shares = sharesNew;
            stocks = stocksNew;
        } else {
            int i = 0;
            for (Map.Entry<String, Integer> entry : sharesMap.entrySet()) {
                shares[i] = entry.getValue();
                stocks[i] = entry.getKey();
                i++;
            }
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        String filenamePrices = args[1];
        In in = new In(filename);
        StockPrice stockPrice = new StockPrice(filenamePrices);
        StockAccountNew account = new StockAccountNew(in, stockPrice);
        account.printReport();
        StdOut.println("TOTAL = " + account.valueOf());
        // input: java StockAccountNew Turing.txt TuringStockPrices.txt TuringReport.txt
        account.buy(3, "ADBE");
        account.buy(3, "TEST");
        account.sell(7, "IBM");
        account.sell(25, "GOOG");
        StdOut.println();
        account.printReport();
        account.save(args[2]);
    }
}
