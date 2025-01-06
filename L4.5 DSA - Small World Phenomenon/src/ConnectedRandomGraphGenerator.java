public class ConnectedRandomGraphGenerator {
    // Generator for random connected graph (The Erdös–Renyi model)

    public static GraphT generateRandomGraph(int n, double p) {
        GraphT graph = new GraphT();

        // Add edges with probability p
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (StdRandom.bernoulli(p)) {
                    String v = "" + i;
                    String w = "" + j;
                    graph.addEdge(v, w);
                }
            }
        }

        // Ensure the graph is connected
        if (isConnected(graph, n)) {
            ensureConnected(graph, n);
        }

        return graph;
    }

    // Check if the graph is connected
    private static boolean isConnected(GraphT graph, int n) {
        boolean[] visited = new boolean[n];
        dfs(graph, "0", visited);
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }

    // Depth-first search to check connectivity
    private static void dfs(GraphT graph, String v, boolean[] visited) {
        int i = Integer.parseInt(v);
        visited[i] = true;
        for (String w : graph.adjacentTo(v)) {
            if (!visited[Integer.parseInt(w)]) dfs(graph, w, visited);
        }
    }

    // Ensure the graph is connected by adding random edges
    private static void ensureConnected(GraphT graph, int n) {
        SET<String> addedEdges = new SET<>();
        while (!isConnected(graph, n)) {
            String v = "" + StdRandom.uniformInt(n);
            String w = "" + StdRandom.uniformInt(n);
            String edge = v + " " + w;
            String reverseEdge = w + " " + v;

            if (!graph.hasEdge(v, w) && !v.equals(w) && addedEdges.contains(edge) && addedEdges.contains(reverseEdge)) {
                graph.addEdge(v, w);
                addedEdges.add(edge);
                addedEdges.add(reverseEdge);
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 1000;
        double p = 0.01;
        GraphT G = generateRandomGraph(n, p);
        G.toFile("G1000random.txt");
        StdOut.printf("number of vertices     = %7d\n", G.V());
        StdOut.printf("number of edges        = %7d\n", G.E());
        StdOut.printf("average degree         = %7.3f\n", SmallWorldT.averageDegree(G));
        StdOut.printf("average path length    = %7.3f\n", SmallWorldT.averagePathLength(G));
        StdOut.printf("clustering coefficient = %7.3f\n", SmallWorldT.clusteringCoefficient(G));
        StdOut.println("is G small world G? " + SmallWorldT.isSmallWorld(G));
    }
}
