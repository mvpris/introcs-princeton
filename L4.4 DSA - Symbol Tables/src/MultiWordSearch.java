import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MultiWordSearch {
    public static int[] findSmallestInterval(List<String> text, String[] queryWords) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : queryWords) {
            wordCount.put(word, 0);
        }

        int requiredWords = queryWords.length;
        int foundWords = 0;
        int left = 0;
        int minLeft = -1, minRight = -1;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < text.size(); right++) {
            String word = text.get(right);
            if (wordCount.containsKey(word)) {
                if (wordCount.get(word) == 0) {
                    foundWords++;
                }
                wordCount.put(word, wordCount.get(word) + 1);
            }

            while (foundWords == requiredWords) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }

                String leftWord = text.get(left);
                if (wordCount.containsKey(leftWord)) {
                    wordCount.put(leftWord, wordCount.get(leftWord) - 1);
                    if (wordCount.get(leftWord) == 0) {
                        foundWords--;
                    }
                }
                left++;
            }
        }

        return new int[]{minLeft, minRight};
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            StdOut.println("Please provide query words as command line arguments.");
            return;
        }

        String[] queryWords = args;

        List<String> text = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            text.add(StdIn.readString());
        }

        int[] result = findSmallestInterval(text, queryWords);
        if (result[0] == -1) {
            StdOut.println("No interval found containing all query words.");
        } else {
            StdOut.printf("Smallest interval: [%d, %d]\n", result[0], result[1]);
        }
    }
}
