public class LookupMultiple {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        String[] database = in.readAllLines();
        StdRandom.shuffle(database);
        ST<String, Queue<String>> st = new ST<>();

        for (String line : database) {
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            if (!st.contains(key)) st.put(key, new Queue<>());
            Queue<String> queue = st.get(key);
            queue.enqueue(val);
        }

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            StdOut.println(st.get(key));
        }
    }
}
