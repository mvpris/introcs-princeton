import java.util.NoSuchElementException;

public class GraphGenericBipartite<V1 extends Comparable<V1>, V2 extends Comparable<V2>> {
    private final ST<V1, SET<V2>> st1;
    private final ST<V2, SET<V1>> st2;
    private int E;

    public GraphGenericBipartite() {
        st1 = new ST<>();
        st2 = new ST<>();
    }

    public GraphGenericBipartite(GraphGenericBipartite<V1, V2> G) {
        st1 = new ST<>();
        for (V1 v : G.st1.keys()) {
            this.st1.put(v, G.st1.get(v));
        }
        st2 = new ST<>();
        for (V2 v : G.st2.keys()) {
            this.st2.put(v, G.st2.get(v));
        }
        this.E = G.E;
    }

    @SuppressWarnings("unchecked")
    public GraphGenericBipartite(String filename, String delimiter) {
        st1 = new ST<>();
        st2 = new ST<>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            V1 v1 = (V1) names[0];
            V2 v2 = (V2) names[1];
            addEdge(v1, v2);
        }
    }

    public void addEdge(V1 v1, V2 v2) {
        if (!hasVertex1(v1)) st1.put(v1, new SET<>());
        if (!hasVertex2(v2)) st2.put(v2, new SET<>());
        if (!hasEdge(v1, v2)) E++;
        st1.get(v1).add(v2);
        st2.get(v2).add(v1);
    }

    public void addVertex1(V1 v) {
        if (!hasVertex1(v)) st1.put(v, new SET<>());
    }

    public void addVertex2(V2 v) {
        if (!hasVertex2(v)) st2.put(v, new SET<>());
    }

    public int V() {
        return st1.size() + st2.size();
    }

    public int E() {
        return E;
    }

    public Iterable<V1> vertices1() {
        return st1.keys();
    }

    public Iterable<V2> vertices2() {
        return st2.keys();
    }

    public Iterable<V2> adjacentTo1(V1 v) {
        return st1.get(v);
    }

    public Iterable<V1> adjacentTo2(V2 v) {
        return st2.get(v);
    }

    public int degree1(V1 v) {
        if (st1.contains(v)) return st1.get(v).size();
        else return 0;
    }

    public int degree2(V2 v) {
        if (st2.contains(v)) return st2.get(v).size();
        else return 0;
    }

    public boolean hasVertex1(V1 v) {
        return st1.contains(v);
    }

    public boolean hasVertex2(V2 v) {
        return st2.contains(v);
    }

    public boolean hasEdge(V1 v1, V2 v2) {
        validateVertex1(v1);
        validateVertex2(v2);
        return st1.get(v1).contains(v2);
    }

    private void validateVertex1(V1 v) {
        if (!hasVertex1(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

    private void validateVertex2(V2 v) {
        if (!hasVertex2(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

    public void remove(V1 v1, V2 v2) {
        validateVertex1(v1);
        validateVertex2(v2);
        if (hasEdge(v1, v2)) {
            st1.get(v1).remove(v2);
            st1.remove(v1);
            st2.get(v2).remove(v1);
            st2.remove(v2);
            E--;
        } else
            throw new NoSuchElementException("Vertices are not connected by an edge");
    }

    public GraphGenericBipartite<V1, V2> subgraph(SET<V1> vertices1, SET<V2> vertices2) {
        GraphGenericBipartite<V1, V2> result = new GraphGenericBipartite<>();
        for (V1 v1 : vertices1) {
            if (hasVertex1(v1)) {
                result.addVertex1(v1);
                for (V2 v2 : adjacentTo1(v1)) {
                    if (vertices2.contains(v2)) {
                        result.addEdge(v1, v2);
                    }
                }
            }
        }
        for (V2 v2 : vertices2) {
            if (hasVertex2(v2)) {
                result.addVertex2(v2);
                for (V1 v1 : adjacentTo2(v2)) {
                    if (vertices1.contains(v1)) {
                        result.addEdge(v1, v2);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (V1 v1 : st1.keys()) {
            s.append(v1).append("  ");
            for (V2 v2 : st1.get(v1)) {
                s.append(v2).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        GraphGenericBipartite<String, String> G = new GraphGenericBipartite<>();
        while (!StdIn.isEmpty()) {
            G.addEdge(StdIn.readString(), StdIn.readString());
        }
        StdOut.print(G);
    }
}
