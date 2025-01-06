public class app3131 {
    public static void main(String[] args) {
        String[] key1 = args[0].split("");
        String[] key2 = args[1].split("");
        int n = key1.length;
        In in = new In();
        Out out = new Out();


        if (key1.length != key2.length) {
            throw new IllegalArgumentException("Length of key strings are not equal.");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (key1[i].equals(key2[j])) {
                    throw new IllegalArgumentException("Letters in key strings must appear only once.");
                }
            }
        }

        while (!in.isEmpty()) {
            String[] s = in.readAllStrings();
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s[i].length(); j++) {
                    boolean flag = false;
                    String letter = String.valueOf(s[i].charAt(j));
                    for (int k = 0; k < n; k++) {
                        if (letter.equals(key1[k]) || letter.equals(key2[k])) flag = true;
                        if (letter.equals(key1[k])) out.print(key2[k]);
                        else if (letter.equals(key2[k])) out.print(key1[k]);
                    }
                    if (!flag) {
                        throw new IllegalArgumentException("Std Input string has letters not found in key strings");
                    }
                }
                out.print(" ");
            }
            out.println();
        }
    }
}
