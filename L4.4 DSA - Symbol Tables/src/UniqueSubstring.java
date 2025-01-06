import java.util.TreeSet;

public class UniqueSubstring {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String text = StdIn.readAll().trim().replaceAll("\\s+", "");

        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i <= text.length() - k; i++) {
            String substring = text.substring(i, i + k);
            set.add(substring);
        }

        StdOut.println("Total unique substrings of length " + k + ": " + set.size());
        StdOut.println(set);
        // input: java UniqueSubstring 3 < UniqueSubstring.txt
    }
}
