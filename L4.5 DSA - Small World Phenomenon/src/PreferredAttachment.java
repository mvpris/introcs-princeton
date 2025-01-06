import java.util.HashMap;
import java.util.Map;

public class PreferredAttachment {
    private static int selectPage(Map<Integer, Integer> indegree) {
        int totalIndegree = 0;
        for (int count : indegree.values()) {
            totalIndegree += count;
        }

        int targetIndegree = StdRandom.uniformInt(totalIndegree);
        int cumulativeIndegree = 0;
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            cumulativeIndegree += entry.getValue();
            if (cumulativeIndegree > targetIndegree) {
                return entry.getKey();
            }
        }

        // Fallback in case no page is selected
        return 0;
    }

    public static void main(String[] args) {
        int numPages = 1000; // Number of web pages
        double p = 0.3; // Probability of choosing a random existing page
        Map<Integer, Integer> indegree = new HashMap<>();
        int[] links = new int[numPages];

        // Initialize the first page
        links[0] = 1; // First page links to itself
        indegree.put(0, 1);


        for (int i = 1; i < numPages; i++) {
            int target;
            if (StdRandom.bernoulli(p)) {
                // Choose a random existing page
                target = StdRandom.uniformInt(i);
            } else {
                // Choose a page with probability proportional to its indegree
                target = selectPage(indegree);
            }

            links[i] = target;
            indegree.put(target, indegree.getOrDefault(target, 0) + 1);
        }

        // Print histogram data
        Map<Integer, Integer> histogram = new HashMap<>();
        for (int count : indegree.values()) {
            histogram.put(count, histogram.getOrDefault(count, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : histogram.entrySet()) {
            StdOut.printf("Indegree %d: %d pages\n", entry.getKey(), entry.getValue());
        }
    }
}
