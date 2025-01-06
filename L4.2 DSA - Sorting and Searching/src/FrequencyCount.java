public class FrequencyCount {
    public static void main(String[] args) {
        // Print input strings in decreasing order
        // of frequency of occurrence.

        String[] words = StdIn.readAllStrings();
        Merge.sort(words);
        Counter[] zipf = new Counter[words.length];
        int m = 0;

        for (int i = 0; i < words.length; i++) { // Create new counter or increment prev counter.
            if (i == 0 || !words[i].equals(words[i - 1]))
                zipf[m++] = new Counter(words[i], words.length);
            zipf[m - 1].increment();
        }

        Merge.sort(zipf, 0, m);
        for (int j = m - 1; j >= 0; j--)
            StdOut.println(zipf[j]);
    }
}
