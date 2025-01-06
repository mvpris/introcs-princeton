public class StockQuote318 {
    private static String readHTML(String symbol) { // Return HTML corresponding to stock symbol.
        In page = new In("http://finance.yahoo.com/q?s=" + symbol);
        return page.readAll();
    }

    public static double priceOf(String symbol) { // Return current stock price for symbol.
        String html = readHTML(symbol);
        int p = html.indexOf("yfs_l84", 0);
        int from = html.indexOf(">", p);
        int to = html.indexOf("</span>", from);
        String price = html.substring(from + 1, to);
        return Double.parseDouble(price.replaceAll(",", ""));
    }

    public static void main(String[] args) { // Print price of stock specified by symbol.
        String symbol = args[0];
        double price = priceOf(symbol);
        StdOut.println(price);
    }
}
