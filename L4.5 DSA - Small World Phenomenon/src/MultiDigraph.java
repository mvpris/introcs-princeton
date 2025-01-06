public class MultiDigraph {
    private final ST<String, Stack<String>> st;
    private int E;

    public MultiDigraph() {
        st = new ST<>();
    }

    public MultiDigraph(String filename, String delimiter) {
        st = new ST<>();
        In in = new In(filename);

        while (!in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++) {
                addEdge(names[0], names[i]);
            }
        }
    }

    public void addEdge(String v, String w) {
        if (!hasVertex(v)) st.put(v, new Stack<>());
        st.get(v).push(w);
        E++;
    }

    public void addVertex(String v) {
        if (!st.contains(v)) st.put(v, new Stack<>());
    }

    public boolean hasEdge(String v, String w) {
        validateVertex(v);
        for (String adj : st.get(v)) {
            if (adj.equals(w)) return true;
        }
        return false;
    }

    public boolean hasVertex(String v) {
        return st.contains(v);
    }

    private void validateVertex(String v) {
        if (!hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

    public Iterable<String> adjacentTo(String v) {
        validateVertex(v);
        return st.get(v);
    }

    public Iterable<String> adjacentFrom(String v) {
        Queue<String> queue = new Queue<>();
        for (String w : st.keys()) {
            for (String adj : st.get(w)) {
                if (adj.equals(v)) queue.enqueue(w);
            }
        }
        return queue;
    }

    public int V() {
        return st.size();
    }

    public int E() {
        return E;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String v : st.keys()) {
            s.append(v).append("  ");
            for (String w : st.get(v)) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {

    }
}

