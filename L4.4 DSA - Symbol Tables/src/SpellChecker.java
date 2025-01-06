import java.util.TreeSet;

public class SpellChecker {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        StdRandom.shuffle(dictionary);

        TreeSet<String> set = new TreeSet<>();
        for (String word : dictionary) set.add(word);

//        Alternative implementations of add operation of set
//        Collections.addAll(set, dictionary);
//        set.addAll(Arrays.asList(dictionary));
//        TreeSet<String> set = new TreeSet<>(Arrays.asList(dictionary));

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.endsWith("ing")) {
                if (!set.contains(word.substring(0, word.length() - 3))) StdOut.println(word);
            } else if (word.endsWith("ed")) {
                if (!set.contains(word.substring(0, word.length() - 2))) StdOut.println(word);
            } else if (!set.contains(word)) StdOut.println(word);
        }
    }
}
