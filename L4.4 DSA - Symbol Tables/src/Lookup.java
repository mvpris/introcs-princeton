public class Lookup {
    public static void main(String[] args) { // Build dictionary, provide values for keys in StdIn.
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        String[] database = in.readAllLines();
        StdRandom.shuffle(database);
        ST<String, String> st = new ST<>();
        for (int i = 0; i < database.length; i++) { // Extract key, value from one line and add to ST.
            String[] tokens = database[i].split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }
        while (!StdIn.isEmpty()) { // Read key and provide value.
            String s = StdIn.readString();
            StdOut.println(st.get(s));
        }
    }
}
