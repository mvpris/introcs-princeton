public class SpellCorrector {
    public static void main(String[] args) {
        In in = new In(args[0]);

        String[] words = in.readAllLines();
        StdRandom.shuffle(words);

        ST<String, String> st = new ST<>();
        for (String line : words) {
            String[] tokens = line.split(",");
            st.put(tokens[0], tokens[1]);
        }

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            StdOut.println(st.get(word));
        }
    }
}
