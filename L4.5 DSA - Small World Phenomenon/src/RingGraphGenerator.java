public class RingGraphGenerator {
    // Generator for 2-ring graphs with/without random shortcuts (regular ring lattice k=4, Watts-Strogatz base model)

    private static String[] consecutiveVertices(int lo, int hi) {
        String[] result = new String[hi - lo];
        for (int i = 0; i < result.length; i++) {
            result[i] = "" + (lo + i);
        }
        return result;
    }

    private static String[] evenVertices(int n) {
        String[] result = new String[n / 2];
        for (int i = 0; i < n / 2; i++) {
            result[i] = "" + (2 * i);
        }
        return result;
    }

    private static String[] oddVertices(int n) {
        String[] result = new String[n / 2];
        for (int i = 0; i < n / 2; i++) {
            result[i] = "" + (2 * i + 1);
        }
        return result;
    }

    public static GraphT generateGraphConsecutive(int n) {
        String[] ring1 = consecutiveVertices(0, n / 2);
        String[] ring2 = consecutiveVertices(n / 2, n);

        GraphT graph = new GraphT();
        for (int i = 0; i < ring1.length; i++) {
            graph.addEdge(ring1[i], ring1[(i + 1) % ring1.length]);
            graph.addEdge(ring2[i], ring2[(i + 1) % ring2.length]);
            graph.addEdge(ring1[i], ring2[i]);
            graph.addEdge(ring2[i], ring1[(i + 1) % ring1.length]);
        }
        return graph;
    }

    public static GraphT generateGraphEvenOdd(int n) {
        String[] ring1 = evenVertices(n);
        String[] ring2 = oddVertices(n);

        GraphT graph = new GraphT();
        for (int i = 0; i < ring1.length; i++) {
            graph.addEdge(ring1[i], ring1[(i + 1) % ring1.length]);
            graph.addEdge(ring2[i], ring2[(i + 1) % ring2.length]);
            graph.addEdge(ring1[i], ring2[i]);
            graph.addEdge(ring2[i], ring1[(i + 1) % ring1.length]);
        }
        return graph;
    }

    public static GraphT generateRingShortcutsGraph(int n) {
        String[] ring1 = evenVertices(n);
        String[] ring2 = oddVertices(n);

        GraphT graph = new GraphT();
        for (int i = 0; i < ring1.length; i++) {
            graph.addEdge(ring1[i], ring1[(i + 1) % ring1.length]);
            graph.addEdge(ring2[i], ring2[(i + 1) % ring2.length]);
            graph.addEdge(ring1[i], ring2[i]);
            graph.addEdge(ring2[i], ring1[(i + 1) % ring1.length]);
        }

        // Add shortcuts (n/2 shortcuts)
        for (int i = 0; i < n / 2; i++) {
            String v = "" + StdRandom.uniformInt(graph.V());
            String w = "" + StdRandom.uniformInt(graph.V());
            while (graph.hasEdge(v, w) || v.equals(w)) {
                v = "" + StdRandom.uniformInt(graph.V());
                w = "" + StdRandom.uniformInt(graph.V());
            }
            graph.addEdge(v, w);
        }
        return graph;
    }

    public static void addRandomShortcuts(GraphT G, int n) {
        for (int i = 0; i < n; i++) {
            String v = "" + StdRandom.uniformInt(G.V());
            String w = "" + StdRandom.uniformInt(G.V());
            while (G.hasEdge(v, w) || v.equals(w)) {
                v = "" + StdRandom.uniformInt(G.V());
                w = "" + StdRandom.uniformInt(G.V());
            }
            G.addEdge(v, w);
        }
    }

    public static void main(String[] args) {
        // Graph G1c (consecutive vertices)
        // Define vertices for the two rings
        String[] ring1c = {"A", "B", "C", "D"};
        String[] ring2c = {"E", "F", "G", "H"};
        // Initialize G1c
        GraphT G1c = new GraphT();
        // Add edges for ring1, ring2 and connect rings edges (outer ring)
        for (int i = 0; i < ring1c.length; i++) {
            G1c.addEdge(ring1c[i], ring1c[(i + 1) % ring1c.length]);
            G1c.addEdge(ring2c[i], ring2c[(i + 1) % ring2c.length]);
            G1c.addEdge(ring1c[i], ring2c[i]);
            G1c.addEdge(ring2c[i], ring1c[(i + 1) % ring1c.length]);
        }
        // Write to file
        G1c.toFile("G1c.txt");


        // Graph G1EO (Even-Odd vertices)
        String[] ring1EO = {"A", "C", "E", "G"};
        String[] ring2EO = {"B", "D", "F", "H"};
        GraphT G1EO = new GraphT();
        for (int i = 0; i < ring1c.length; i++) {
            G1EO.addEdge(ring1EO[i], ring1EO[(i + 1) % ring1EO.length]);
            G1EO.addEdge(ring2EO[i], ring2EO[(i + 1) % ring2EO.length]);
            G1EO.addEdge(ring1EO[i], ring2EO[i]);
            G1EO.addEdge(ring2EO[i], ring1EO[(i + 1) % ring1EO.length]);
        }
        G1EO.toFile("G1EO.txt");


        // Generate ints graphs (n=8,n=1000,n=1000+5)
        int n = 8;
        GraphT G8c = generateGraphConsecutive(n);
        GraphT G8EO = generateGraphEvenOdd(n);
        n = 1000;
        GraphT G1000c = generateGraphConsecutive(n);
        GraphT G1000EO = generateGraphEvenOdd(n);
        GraphT G1000EOR = generateRingShortcutsGraph(n);

        // Write graphs to files
        G8c.toFile("G8c.txt");
        G8EO.toFile("G8EO.txt");
        G1000c.toFile("G1000c.txt");
        G1000EO.toFile("G1000EO.txt");
        G1000EOR.toFile("G1000EOR.txt");
    }
}
