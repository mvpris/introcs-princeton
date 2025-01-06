public class BollobasChung {
    public static GraphT createGraph(int V) {
        if (V % 2 != 0) throw new IllegalArgumentException("V must be even");

        GraphT G = new GraphT();

        // Create a 2-ring
        for (int i = 0; i < V; i++) {
            G.addVertex(String.valueOf(i));
        }

        for (int i = 0; i < V; i++) {
            G.addEdge(String.valueOf(i), String.valueOf((i + 1) % V));
            G.addEdge(String.valueOf(i), String.valueOf((i + 2) % V));
        }

        // Random matching
        Integer[] vertices = new Integer[V];
        for (int i = 0; i < V; i++) {
            vertices[i] = i;
        }
        StdRandom.shuffle(vertices);

        for (int i = 0; i < V; i += 2) {
            G.addEdge(String.valueOf(vertices[i]), String.valueOf(vertices[i + 1]));
        }

        return G;
    }

    public static void main(String[] args) {
        int V = 1000;
        GraphT graph = createGraph(V);

        // Determine the degree of each vertex
        int[] degrees = new int[V];
        for (String v : graph.vertices()) {
            degrees[Integer.parseInt(v)] = graph.degree(v);
        }

        // Print the degree of each vertex
        StdOut.println("Vertex degrees:");
        for (int i = 0; i < V; i++) {
            StdOut.printf("Vertex %d: Degree %d\n", i, degrees[i]);
        }

        // Estimate the average degree, average path length and clustering coefficient
        double averageDegree = SmallWorldT.averageDegree(graph);
        double averagePathLength = SmallWorldT.averagePathLength(graph);
        double clusteringCoefficient = SmallWorldT.clusteringCoefficient(graph);

        StdOut.printf("number of vertices            =  %7d\n", graph.V());
        StdOut.printf("number of edges               =  %7d\n", graph.E());
        StdOut.printf("average degree                =  %7.3f\n", averageDegree);
        StdOut.printf("average path length           =  %7.3f\n", averagePathLength);
        StdOut.printf("clustering coefficient        =  %7.3f\n", clusteringCoefficient);
        StdOut.printf("is graph a small world graph  =  %7b\n", SmallWorldT.isSmallWorld(graph,
                averageDegree, averagePathLength, clusteringCoefficient));
    }
}
