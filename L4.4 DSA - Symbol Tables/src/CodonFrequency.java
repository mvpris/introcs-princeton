import java.util.TreeMap;

public class CodonFrequency {
    public static void main(String[] args) {
        String genome = StdIn.readAll().toUpperCase().replaceAll("[^A-Z]", "");
        int count = 0, totalCodons = 0;
        TreeMap<String, Integer> result = new TreeMap<>();
        TreeMap<String, Integer> map = new TreeMap<>();

        // Add codons
        for (int i = 0; i <= genome.length() - 3; i += 3) {
            if (count == 1000) {
                for (String codon : map.keySet()) {
                    result.put(codon, result.getOrDefault(codon, 0) + map.get(codon));
                }
                map.clear();
                count = 0;
            }
            String codon = genome.substring(i, i + 3);
            map.put(codon, map.getOrDefault(codon, 0) + 1);
            count++;
            totalCodons++;
        }

        // Add remaining codons in map to result
        for (String codon : map.keySet()) {
            result.put(codon, result.getOrDefault(codon, 0) + map.get(codon));
        }

        // Calculate frequencies per thousand and print
        double factor = 1000.0 / totalCodons;
        for (String codon : result.keySet()) {
            StdOut.printf("%s %.1f\n", codon, result.get(codon) * factor);
        }
    }
}
