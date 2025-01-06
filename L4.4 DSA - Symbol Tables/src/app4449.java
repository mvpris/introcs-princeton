import java.util.LinkedList;
import java.util.TreeMap;

public class app4449 {
    public static void populateSymbolTable(String[] webpages, TreeMap<String, LinkedList<String>> st) {
        for (String webpage : webpages) {
            In in = new In(webpage);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.containsKey(word)) st.put(word, new LinkedList<>());
                LinkedList<String> queue = st.get(word);
                if (!queue.contains(webpage)) queue.add(webpage);
            }
        }
    }

    public static void main(String[] args) {
        String[] webpages = StdIn.readAllLines();
        TreeMap<String, LinkedList<String>> st = new TreeMap<>();
        populateSymbolTable(webpages, st);
        StdOut.println("Enter a word to search:");
        String query = StdIn.readString();

        LinkedList<String> result = st.get(query);
        if (result != null && !result.isEmpty())
            StdOut.println("Word found in the following web pages:" + result);
        else
            StdOut.println("Word not found in any web pages.");
    }
}
