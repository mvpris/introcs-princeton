public class StockPrice {
    private final double[] prices;
    private final String[] stocks;

    public StockPrice(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        prices = new double[n];
        stocks = new String[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.readDouble();
            stocks[i] = in.readString();
        }
    }

    public double[] getPrices() {
        return prices;
    }

    public String[] getStocks() {
        return stocks;
    }

    public static void main(String[] args) {
        String filename = args[0];
        StockPrice stockPrice = new StockPrice(filename);
        double[] price1 = stockPrice.getPrices();
        String[] stocks = stockPrice.getStocks();
        StdArrayIO.print(price1);
        System.out.println();
        System.out.println(stocks.length);
        for (String stock : stocks) {
            System.out.print(stock + " ");
        }
        System.out.println();
    }
}
