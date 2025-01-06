public class Index2 {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        int minocc = Integer.parseInt(args[1]);

        ST<String, Queue<Integer>> st = new ST<>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String s = StdIn.readString();
            if (s.length() < minlen) continue;
            if (!st.contains(s)) st.put(s, new Queue<>());
            Queue<Integer> queue = st.get(s);
            queue.enqueue(i);
        }

        Out out = new Out(args[2]);
        for (String s : st.keys()) {
            Queue<Integer> queue = st.get(s);
            if (queue.size() >= minocc) out.println(s + ": " + queue);
        }
    }
}
