public class app2319 {
    // alternate implementation
    public static void comb2(String s) {
        comb2("", s);
    }

    private static void comb2(String prefix, String s) {
        StdOut.println(prefix);
        for (int i = 0; i < s.length(); i++)
            comb2(prefix + s.charAt(i), s.substring(i + 1));
    }


    // read in N from command line, and print all subsets among N elements
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);

        // using second implementation
        comb2(elements);
    }
}
