public class LookupAndPut {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        String[] database = in.readAllLines();
        StdRandom.shuffle(database);
        ST<String, String> st = new ST<>();
        for (String field : database) {
            String[] tokens = field.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.equals("+")) {
                String keyPut = StdIn.readString();
                String valPut = StdIn.readString();
                st.put(keyPut, valPut);
            } else StdOut.println(st.get(key));
        }
    }
}
