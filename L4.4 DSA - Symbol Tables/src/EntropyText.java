import java.util.HashMap;

public class EntropyText {
    public static String[] processString(String input) {
        String lowerCaseString = input.toLowerCase();
        String result = lowerCaseString.replaceAll("[\\p{Punct}]", " ");
        return result.trim().split("\\s+");
    }

    public static void main(String[] args) {
        String text = StdIn.readAll();
        String[] words = processString(text);

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int n = words.length;
        int k = map.size();

        if (n == 0) {
            StdOut.println("E = 0");
            return;
        }

        double sum = 0.0;
        double log2 = Math.log(2);
        for (String word : map.keySet()) {
            double fraction = (map.get(word) / (double) n);
            sum += fraction * (Math.log(k / fraction) / log2);
        }

        double entropy = 1.0 / (n * (Math.log(n) / log2)) * sum;

        StdOut.println("E = " + entropy);
    }
}
