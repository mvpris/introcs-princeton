import java.util.Map;
import java.util.TreeMap;

public class DynamicDiscreteDistribution<Item extends Comparable<Item>> {
    private final TreeMap<Item, Integer> treeMap;
    private int totalFrequency;

    public DynamicDiscreteDistribution() {
        treeMap = new TreeMap<>();
        totalFrequency = 0;
    }

    public void add(Item item) {
        if (item == null) throw new IllegalArgumentException("called add() with null item");
        int frequency = treeMap.getOrDefault(item, 0) + 1;
        treeMap.put(item, frequency);
        totalFrequency++;
    }

    public Item random() {
        if (treeMap.isEmpty()) throw new IllegalStateException("called random() with empty distribution");

        // Calculate probabilities
        double[] probabilities = new double[treeMap.size()];
        int i = 0;
        for (Map.Entry<Item, Integer> entry : treeMap.entrySet()) {
            probabilities[i++] = entry.getValue() / (double) totalFrequency;
        }

        // Select a random index based on weighted probabilities
        int randomIndex = StdRandom.discrete(probabilities);

        // Iterate over the entries and find the item corresponding to the random index
        i = 0;
        for (Map.Entry<Item, Integer> entry : treeMap.entrySet()) {
            if (i == randomIndex) return entry.getKey();
            i++;
        }

        // This should never be reached if the logic is correct
        throw new IllegalStateException("random() method failed to select an item");
    }

    public static void main(String[] args) {
        DynamicDiscreteDistribution<String> distribution = new DynamicDiscreteDistribution<>();
        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            distribution.add(input);
        }

        StdOut.println("Randomly selected item: " + distribution.random());

        // input: java DynamicDiscreteDistribution < DDD.txt
        // should return: 0.2 times "one", 0.3 times "two" and 0.5 times "three", which it does.
    }
}
