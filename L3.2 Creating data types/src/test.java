public class test {
    public static void main(String[] args) {
        String filename = args[0];
        String filenamePrices = filename.substring(0, filename.indexOf(".")) + "StockPrices.txt";
        System.out.println(filenamePrices);
    }
}
