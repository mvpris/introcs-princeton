public class Index {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        int minocc = Integer.parseInt(args[1]);

        ST<String, Queue<Integer>> st = new ST<>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String word = StdIn.readString();
            if (word.length() < minlen) continue;
            if (!st.contains(word)) st.put(word, new Queue<>());
            Queue<Integer> queue = st.get(word);
            queue.enqueue(i);
        }

        for (String s : st) {
            Queue<Integer> queue = st.get(s);
            if (queue.size() >= minocc) StdOut.println(s + ": " + queue);
        }
    }
}
