public class IndexLines {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        int minocc = Integer.parseInt(args[1]);
        ST<String, Queue<Integer>> st = new ST<>();
        int lineNumber = 0;
        while (!StdIn.isEmpty()) {
            lineNumber++;
            String line = StdIn.readLine();
            String[] words = line.split("\\W+"); // Split based on non-word characters
            for (String word : words) {
                if (word.length() < minlen) continue;
                if (!st.contains(word)) st.put(word, new Queue<>());
                Queue<Integer> queue = st.get(word);
                queue.enqueue(lineNumber);
            }
        }
        for (String s : st) {
            Queue<Integer> queue = st.get(s);
            if (queue.size() >= minocc) StdOut.println(s + ": " + queue);
        }
    }
}
