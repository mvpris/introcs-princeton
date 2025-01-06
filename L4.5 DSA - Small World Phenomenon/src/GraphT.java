import java.util.NoSuchElementException;

public class GraphT {
    private final ST<String, SET<String>> st;
    private int E;

    public GraphT() {
        st = new ST<>();
    }

    public GraphT(GraphT G) {
        st = new ST<>();
        for (String v : G.st.keys()) {
            this.st.put(v, G.st.get(v));
        }
        this.E = G.E;
    }

    public GraphT(String filename, String delimiter) {
        st = new ST<>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++) {
                addEdge(names[0], names[i]);
            }
        }
    }

    public void addEdge(String v, String w) {
        if (!hasVertex(v)) st.put(v, new SET<>());
        if (!hasVertex(w)) st.put(w, new SET<>());
        if (!hasEdge(v, w)) E++;
        st.get(v).add(w);
        st.get(w).add(v);
    }

    public void addVertex(String v) {
        if (!hasVertex(v)) st.put(v, new SET<>());
    }

    public int V() {
        return st.size();
    }

    public int E() {
        return E;
    }

    public Iterable<String> vertices() {
        return st.keys();
    }

    public Iterable<String> adjacentTo(String v) {
        validateVertex(v);
        return st.get(v);
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
        return st.get(v).contains(w);
    }

    private void validateVertex(String v) {
        if (!hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

    public void remove(String v, String w) {
        validateVertex(v);
        validateVertex(w);
        if (hasEdge(v, w)) {
            st.get(v).remove(w);
            st.remove(v);
            st.get(w).remove(v);
            st.remove(w);
            E--;
        } else
            throw new NoSuchElementException("Vertices are not connected by an edge");
    }

    public GraphT subgraph(SET<String> vertices) {
        GraphT result = new GraphT();
        for (String v : vertices) {
            if (hasVertex(v)) {
                result.addVertex(v);
                for (String w : adjacentTo(v)) {
                    if (vertices.contains(w)) {
                        result.addEdge(v, w);
                    }
                }
            }
        }
        return result;
    }

    public int maxDegree() {
        int max = 0;
        for (String v : st.keys()) {
            max = Math.max(max, degree(v));
        }
        return max;
    }

    public void toFile(String filename) {
        Out out = new Out(filename);
        SET<String> pairs = new SET<>();
        for (String v : vertices()) {
            for (String w : adjacentTo(v)) {
                String edge1 = v + " " + w;
                String edge2 = w + " " + v;
                if (!pairs.contains(edge1) && !pairs.contains(edge2)) {
                    out.println(edge1);
                    pairs.add(edge1);
                }
            }
        }
        out.close();
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
        GraphT G = new GraphT();
        while (!StdIn.isEmpty()) {
            G.addEdge(StdIn.readString(), StdIn.readString());
        }

//        GraphT G2 = new GraphT("movies.txt", "/");
//        Out out = new Out("movies-graph2.txt");
//        out.print(G2);
//        StdOut.println("Done");
    }
}
