public class app2318 {
    // print n! permutation of the characters of the string s (in order)
    public static void perm1(String s, int diff) {
        perm1("", s, diff);
    }

    private static void perm1(String prefix, String s, int diff) {
        int n = s.length();
        if (n == diff) StdOut.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), diff);
        }

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int diff = n - k;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        perm1(elements, diff);
    }
}
