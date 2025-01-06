public class app3126 {
    public static String readHTML() {
        In in = new In("https://weather.tomorrow.io/");
        return in.readAll();
    }

    public static String temperature() {
        String website = readHTML();
        int p = website.lastIndexOf("_3fQrr5");
        int from = website.indexOf(">", p);
        int to = website.indexOf("</span>", from);
        return website.substring(from + 1, to);
    }

    public static void main(String[] args) {
        System.out.println(temperature());
    }
}
