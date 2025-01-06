public class Graph456 {
    private final ST<String, Queue<String>> st;
    private int E;

    public Graph456() {
        st = new ST<>();
    }

    public Graph456(Graph456 G) {
        st = new ST<>();
        for (String v : G.st.keys()) {
            this.st.put(v, G.st.get(v));
        }
        this.E = G.E;
    }

    public Graph456(String filename, String delimiter) {
        st = new ST<>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (String name : names) {
                addEdge(names[0], name);
            }
        }
    }

    public void addEdge(String v, String w) {
        if (!st.contains(v)) st.put(v, new Queue<>());
        if (!st.contains(w)) st.put(w, new Queue<>());
        E++;
        st.get(v).enqueue(w);
        st.get(w).enqueue(v);
    }

    public void addVertex(String v) {
        if (!hasVertex(v)) st.put(v, new Queue<>());
    }

    public int V() {
        return st.size();
    }

    public int E() {
        return E;
    }

    private void validateVertex(String v) {
        if (!hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

    public Iterable<String> adjacentTo(String v) {
        return st.get(v);
    }

    public Iterable<String> vertices() {
        return st.keys();
    }

    public int degree(String v) {
        if (st.contains(v)) return st.get(v).size();
        else return 0;
    }

    public boolean hasVertex(String v) {
        return st.contains(v);
    }

    public boolean hasEdge(String v, String w) {
        validateVertex(v);
        validateVertex(w);
        boolean flag = false;
        for (String k : st.get(v))
            if (k.equals(w)) {
                flag = true;
                break;
            }
        return flag;
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
        Graph456 G = new Graph456();
        while (!StdIn.isEmpty()) {
            G.addEdge(StdIn.readString(), StdIn.readString());
        }
        StdOut.print(G);
//        Graph456 G2 = new Graph456("tinyGraph.txt", " ");
//        StdOut.print(G2);
    }
}
