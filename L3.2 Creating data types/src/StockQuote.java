public class StockQuote {
    private static String readHTML(String symbol) { // Return HTML corresponding to stock symbol.
        In page = new In("https://finance.yahoo.com/quote/" + symbol);
        return page.readAll();
    }

    public static double priceOf(String symbol) { // Return current stock price for symbol.
        String html = readHTML(symbol);
        Out out = new Out("Finance.txt");
//        out.print(html);
        int p = html.lastIndexOf("PREV_CLOSE-value");
        System.out.println("p=" + p);
        int from = html.indexOf(">", p);
        System.out.println("from=" + from);
        int to = html.indexOf("</td>", from);
        System.out.println("to=" + to);
        String price = html.substring(from + 1, to);
        return Double.parseDouble(price.replaceAll(",", ""));
    }

    public static void main(String[] args) { // Print price of stock specified by symbol.
        String symbol = args[0];
        double price = priceOf(symbol);
        StdOut.println(price);
    }
}
