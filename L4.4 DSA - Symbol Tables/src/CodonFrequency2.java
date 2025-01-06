import java.util.TreeMap;

public class CodonFrequency2 {
    public static void main(String[] args) {
        String genome = StdIn.readAll().toUpperCase().replaceAll("[^A-Z]", "");
        TreeMap<String, Integer> map = new TreeMap<>();

        // Count codon occurrences
        for (int i = 0; i <= genome.length() - 3; i += 3) {
            String codon = genome.substring(i, i + 3);
            map.put(codon, map.getOrDefault(codon, 0) + 1);
        }

        int totalCodons = map.values().stream().mapToInt(Integer::intValue).sum();

        // Calculate frequencies per thousand
        double factor = 1000.0 / totalCodons;
        for (String codon : map.keySet()) {
            double frequency = map.get(codon) * factor;
            StdOut.printf("%s %.1f\n", codon, frequency);
        }
    }
}

