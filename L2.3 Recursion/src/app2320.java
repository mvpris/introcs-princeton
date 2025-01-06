public class app2320 {
    // alternate implementation
    public static void comb2(String s, int k) {
        comb2("", s, k);
    }

    private static void comb2(String prefix, String s, int k) {
        if (k == 0) StdOut.println(prefix);
        else {
            for (int i = 0; i < s.length(); i++)
                comb2(prefix + s.charAt(i), s.substring(i + 1), k - 1);
        }
    }


    // read in N from command line, and print all subsets among N elements
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);

        // using second implementation
        comb2(elements, k);
    }
}
