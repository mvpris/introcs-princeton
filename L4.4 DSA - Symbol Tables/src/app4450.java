import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class app4450 {
    public static void populateSymbolTable(String[] webpages, TreeMap<String, LinkedList<String>> st) {
        for (String webpage : webpages) {
            In in = new In(webpage);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.containsKey(word)) {
                    st.put(word, new LinkedList<>());
                }
                LinkedList<String> queue = st.get(word);
                if (!queue.contains(webpage)) { // Avoid duplicate entries
                    queue.add(webpage);
                }
            }
        }
    }

    public static List<String> multiWordQuery(TreeMap<String, LinkedList<String>> st, String[] queryWords) {
        if (queryWords.length == 0) {
            return new ArrayList<>();
        }

        // Start with the list of web pages for the first query word
        LinkedList<String> result = new LinkedList<>(st.getOrDefault(queryWords[0], new LinkedList<>()));

        // Intersect with the lists of web pages for the remaining query words
        for (int i = 1; i < queryWords.length; i++) {
            LinkedList<String> tempList = st.getOrDefault(queryWords[i], new LinkedList<>());
            result.retainAll(tempList); // Retain only elements that are in both lists
        }

        return result;
    }

    public static void main(String[] args) {
        String[] webpages = StdIn.readAllLines();
        TreeMap<String, LinkedList<String>> st = new TreeMap<>();
        populateSymbolTable(webpages, st);

        StdOut.println("Enter words to search (separated by space):");
        String query = StdIn.readLine();
        String[] queryWords = query.split("\\s+");

        List<String> result = multiWordQuery(st, queryWords);
        if (!result.isEmpty()) {
            StdOut.println("Words found in the following web pages: " + result);
        } else {
            StdOut.println("Words not found in any web pages.");
        }
    }
}
