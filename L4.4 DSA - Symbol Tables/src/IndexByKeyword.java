public class IndexByKeyword {
    public static void main(String[] args) {
        In in = new In(args[0]);

        ST<String, Queue<Integer>> st = new ST<>();

        while (!in.isEmpty()) st.put(in.readString(), new Queue<>());

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            if (st.contains(key)) st.get(key).enqueue(i);
        }

        for (String key : st.keys()) StdOut.println(key + ": " + st.get(key));
    }
}
