public class GridGraphGenerator {
    private static String[][] generateVertices(int n) {
        String[][] result = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = "" + (i * n + j);
            }
        }
        return result;
    }

    public static GraphT generateGridGraph(int n) {
        GraphT graph = new GraphT();
        String[][] v = generateVertices(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) graph.addEdge(v[i][j], v[i][j + 1]);
                if (i < n - 1) graph.addEdge(v[i][j], v[i + 1][j]);
            }
        }

        return graph;
    }

    public static GraphT generateGridGraphWithShortcuts(int n, int m) {
        GraphT graph = generateGridGraph(n);

        for (int i = 0; i < m; i++) {
            String v = "" + StdRandom.uniformInt(n * n);
            String w = "" + StdRandom.uniformInt(n * n);
            while (graph.hasEdge(v, w) || v.equals(w)) {
                v = "" + StdRandom.uniformInt(n * n);
                w = "" + StdRandom.uniformInt(n * n);
            }
            graph.addEdge(v, w);
        }

        return graph;
    }

    public static void main(String[] args) {
        int V = 1000;   // Number of vertices
        int n = (int) Math.sqrt(V) + 1; // Grid dimension (n x n grid)
        int m = n / 2;  // Number of shortcuts

        // Generate grid graph
        GraphT gridGraph = generateGridGraph(n);
        gridGraph.toFile("gridGraph.txt");
        StdOut.printf("number of vertices     = %7d\n", gridGraph.V());
        StdOut.printf("number of edges        = %7d\n", gridGraph.E());
        StdOut.printf("average degree         = %7.3f\n", SmallWorldT.averageDegree(gridGraph));
        StdOut.printf("average path length    = %7.3f\n", SmallWorldT.averagePathLength(gridGraph));
        StdOut.printf("clustering coefficient = %7.3f\n", SmallWorldT.clusteringCoefficient(gridGraph));
        StdOut.printf("is k-ring graph small world? " + SmallWorldT.isSmallWorld(gridGraph) + "\n\n");

        // Generate grid graph with shortcuts
        GraphT gridGraphWithShortcuts = generateGridGraphWithShortcuts(n, m);
        gridGraphWithShortcuts.toFile("gridGraphWithShortcuts.txt");
        StdOut.printf("number of vertices     = %7d\n", gridGraphWithShortcuts.V());
        StdOut.printf("number of edges        = %7d\n", gridGraphWithShortcuts.E());
        StdOut.printf("average degree         = %7.3f\n", SmallWorldT.averageDegree(gridGraphWithShortcuts));
        StdOut.printf("average path length    = %7.3f\n", SmallWorldT.averagePathLength(gridGraphWithShortcuts));
        StdOut.printf("clustering coefficient = %7.3f\n", SmallWorldT.clusteringCoefficient(gridGraphWithShortcuts));
        StdOut.printf("is k-ring graph small world? " + SmallWorldT.isSmallWorld(gridGraph) + "\n");
    }
}
