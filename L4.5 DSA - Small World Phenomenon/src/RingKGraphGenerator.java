public class RingKGraphGenerator {

    private static String[] generateVertices(int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = "" + i;
        }
        return result;
    }

    public static GraphT generateKRingGraph(int n, int k) {
        GraphT graph = new GraphT();
        String[] vertices = generateVertices(n);

        // Add edges in a k-ring
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int neighbor = (i + j) % n;
                graph.addEdge(vertices[i], vertices[neighbor]);
            }
        }

        return graph;
    }

    public static GraphT generateKRingGraphWithShortcuts(int n, int k, int m) {
        GraphT graph = generateKRingGraph(n, k);

        // Add random shortcuts
        for (int i = 0; i < m; i++) {
            String v = "" + StdRandom.uniformInt(n);
            String w = "" + StdRandom.uniformInt(n);
            while (graph.hasEdge(v, w) || v.equals(w)) {
                v = "" + StdRandom.uniformInt(n);
                w = "" + StdRandom.uniformInt(n);
            }
            graph.addEdge(v, w);
        }

        return graph;
    }

    public static void main(String[] args) {
        int n = 1000;  // Number of vertices
        int k = 3;     // Each vertex is connected to k nearest neighbors on each side
        int m = n / 2;  // Number of shortcuts

        // Generate k-ring graph
        GraphT kRingGraph = generateKRingGraph(n, k);
        kRingGraph.toFile("3RingGraph.txt");
        StdOut.printf("number of vertices     = %7d\n", kRingGraph.V());
        StdOut.printf("number of edges        = %7d\n", kRingGraph.E());
        StdOut.printf("average degree         = %7.3f\n", SmallWorldT.averageDegree(kRingGraph));
        StdOut.printf("average path length    = %7.3f\n", SmallWorldT.averagePathLength(kRingGraph));
        StdOut.printf("clustering coefficient = %7.3f\n", SmallWorldT.clusteringCoefficient(kRingGraph));
        StdOut.printf("is k-ring graph small world? " + SmallWorldT.isSmallWorld(kRingGraph) + "\n\n");

        // Generate k-ring graph with shortcuts
        GraphT kRingGraphWithShortcuts = generateKRingGraphWithShortcuts(n, k, m);
        kRingGraphWithShortcuts.toFile("3RingGraphWithShortcuts.txt");
        StdOut.printf("number of vertices     = %7d\n", kRingGraphWithShortcuts.V());
        StdOut.printf("number of edges        = %7d\n", kRingGraphWithShortcuts.E());
        StdOut.printf("average degree         = %7.3f\n", SmallWorldT.averageDegree(kRingGraphWithShortcuts));
        StdOut.printf("average path length    = %7.3f\n", SmallWorldT.averagePathLength(kRingGraphWithShortcuts));
        StdOut.printf("clustering coefficient = %7.3f\n", SmallWorldT.clusteringCoefficient(kRingGraphWithShortcuts));
        StdOut.printf("is k-ring graph with shortcuts small world? " + SmallWorldT.isSmallWorld(kRingGraphWithShortcuts) + "\n");
    }
}
