import java.util.NoSuchElementException;

public class GraphGeneric<Vertex extends Comparable<Vertex>> {
    private final ST<Vertex, SET<Vertex>> st;
    private int E;

    public GraphGeneric() {
        st = new ST<>();
    }

    public GraphGeneric(GraphGeneric<Vertex> G) {
        st = new ST<>();
        for (Vertex v : G.st.keys()) {
            this.st.put(v, G.st.get(v));
        }
        this.E = G.E;
    }

    @SuppressWarnings("unchecked")
    public GraphGeneric(String filename, String delimiter) {
        st = new ST<>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (String name : names) {
                addEdge((Vertex) names[0], (Vertex) name);
            }
        }
    }

    public void addEdge(Vertex v, Vertex w) {
        if (!hasVertex(v)) st.put(v, new SET<>());
        if (!hasVertex(w)) st.put(w, new SET<>());
        if (!hasEdge(v, w)) E++;
        st.get(v).add(w);
        st.get(w).add(v);
    }

    public void addVertex(Vertex v) {
        if (!hasVertex(v)) st.put(v, new SET<>());
    }

    public int V() {
        return st.size();
    }

    public int E() {
        return E;
    }

    public Iterable<Vertex> vertices() {
        return st.keys();
    }

    public Iterable<Vertex> adjacentTo(Vertex v) {
        return st.get(v);
    }


    public int degree(Vertex v) {
        if (st.contains(v)) return st.get(v).size();
        else return 0;
    }

    public boolean hasVertex(Vertex v) {
        return st.contains(v);
    }

    public boolean hasEdge(Vertex v, Vertex w) {
        validateVertex(v);
        validateVertex(w);
        return st.get(v).contains(w);
    }

    private void validateVertex(Vertex v) {
        if (!hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

    public void remove(Vertex v, Vertex w) {
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

    public GraphGeneric<Vertex> subgraph(SET<Vertex> vertices) {
        GraphGeneric<Vertex> result = new GraphGeneric<>();
        for (Vertex v : vertices) {
            if (hasVertex(v)) {
                result.addVertex(v);
                for (Vertex w : adjacentTo(v)) {
                    if (vertices.contains(w)) {
                        result.addEdge(v, w);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Vertex v : st.keys()) {
            s.append(v).append("  ");
            for (Vertex w : st.get(v)) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        GraphGeneric<String> G = new GraphGeneric<>();
        while (!StdIn.isEmpty()) {
            G.addEdge(StdIn.readString(), StdIn.readString());
        }
        StdOut.print(G);
    }
}
