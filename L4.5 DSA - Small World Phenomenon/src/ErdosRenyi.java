import java.util.HashMap;
import java.util.Map;

public class ErdosRenyi {
    public static GraphT createGraph(int V, double p) {
        GraphT G = new GraphT();

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (StdRandom.bernoulli(p)) G.addEdge(String.valueOf(i), String.valueOf(j));
            }
        }
        return G;
    }

    public static boolean isConnected(GraphT G) {
        String startVertex = G.vertices().iterator().next();
        SET<String> visited = bfs(G, startVertex);
        return visited.size() == G.V();
    }

    private static SET<String> bfs(GraphT G, String source) {
        Queue<String> queue = new Queue<>();
        SET<String> visited = new SET<>();

        queue.enqueue(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            for (String w : G.adjacentTo(v)) {
                if (!visited.contains(w)) {
                    queue.enqueue(w);
                    visited.add(w);
                }
            }
        }
        return visited;
    }

    public static int largestComponentSize(GraphT G) {
        SET<String> visited = new SET<>();
        int maxSize = 0;
        for (String v : G.vertices()) {
            if (!visited.contains(v)) {
                SET<String> component = bfs(G, v);
                for (String w : component) visited.add(w);
                maxSize = Math.max(maxSize, component.size());
            }
        }
        return maxSize;
    }

    public static Map<Integer, Integer> degreeDistribution(GraphT G) {
        Map<Integer, Integer> degreeCount = new HashMap<>();
        for (String v : G.vertices()) {
            int degree = G.degree(v);
            degreeCount.put(degree, degreeCount.getOrDefault(degree, 0) + 1);
        }
        return degreeCount;
    }

    public static int diameter(GraphT G) {
        int diameter = 0;
        for (String v : G.vertices()) {
            PathFinderT pf = new PathFinderT(G, v);
            for (String w : G.vertices()) {
                int dist = pf.distanceTo(w);
                if (dist != Integer.MAX_VALUE) {
                    diameter = Math.max(diameter, dist);
                }
            }
        }
        return diameter;
    }

    public static void main(String[] args) {
        int V = Integer.parseInt(args[0]);
        double p1 = 1.0 / V;
        double p2 = Math.log(V) / V;
        double p3 = 0.5;
        int trials = 100;

        int connectedCountP1 = 0;
        int connectedCountP2 = 0;
        int largestComponentSizeP1 = 0;
        int largestComponentSizeP2 = 0;
        int maxDegreeP3 = 0;
        double totalClusteringCoefficientP1 = 0;
        double totalClusteringCoefficientP2 = 0;
        int diameterP1 = 0;
        int diameterP2 = 0;

        for (int i = 0; i < trials; i++) {
            GraphT G1 = createGraph(V, p1);
            GraphT G2 = createGraph(V, p2);
            GraphT G3 = createGraph(V, p3);

            if (isConnected(G1)) connectedCountP1++;
            if (isConnected(G2)) connectedCountP2++;

            largestComponentSizeP1 = Math.max(largestComponentSizeP1, largestComponentSize(G1));
            largestComponentSizeP2 = Math.max(largestComponentSizeP2, largestComponentSize(G2));

            maxDegreeP3 = Math.max(maxDegreeP3, G3.maxDegree());

            totalClusteringCoefficientP1 += SmallWorldT.clusteringCoefficient(G1);
            totalClusteringCoefficientP2 += SmallWorldT.clusteringCoefficient(G2);

            diameterP1 = diameter(G1);
            diameterP2 = diameter(G2);
        }

        StdOut.printf("For p = 1/V:\n");
        StdOut.printf("Number of connected graphs: %d/%d\n", connectedCountP1, trials);
        StdOut.printf("Largest component size: %d\n", largestComponentSizeP1);
        StdOut.printf("Average clustering coefficient: %.3f\n", totalClusteringCoefficientP1 / trials);
        StdOut.printf("Diameter: %d\n", diameterP1);
        StdOut.printf("Diameter is logarithmic (log(V)=%.2f): %b\n", Math.log(V), diameterP1 <= Math.log(V));

        StdOut.printf("\nFor p = ln(V)/V:\n");
        StdOut.printf("Number of connected graphs: %d/%d\n", connectedCountP2, trials);
        StdOut.printf("Largest component size: %d\n", largestComponentSizeP2);
        StdOut.printf("Average clustering coefficient: %.3f\n", totalClusteringCoefficientP2 / trials);
        StdOut.printf("Diameter: %d\n", diameterP2);
        StdOut.printf("Diameter is logarithmic (log(V)=%.2f): %b\n", Math.log(V), diameterP2 <= Math.log(V));

        StdOut.printf("\nFor constant p = 0.5:\n");
        StdOut.printf("Maximum vertex degree: %d\n", maxDegreeP3);
        StdOut.printf("Logarithmic bound: %.2f\n", Math.log(V));
        StdOut.printf("Maximum degree is at most logarithmic in V: %b\n", maxDegreeP3 <= Math.log(V));

        // Distribution of degrees
        GraphT graph = createGraph(V, p1);  // Test with p = 1/V
        Map<Integer, Integer> degreeDist = degreeDistribution(graph);
        StdOut.println("\nDegree distribution for p = 1/V:");
        for (Map.Entry<Integer, Integer> entry : degreeDist.entrySet()) {
            StdOut.printf("Degree %d: %d vertices\n", entry.getKey(), entry.getValue());
        }

        graph = createGraph(V, p2); // Test with p = ln(V)/V
        degreeDist = degreeDistribution(graph);
        StdOut.println("\nDegree distribution for p = ln(V)/V:");
        for (Map.Entry<Integer, Integer> entry : degreeDist.entrySet()) {
            StdOut.printf("Degree %d: %d vertices\n", entry.getKey(), entry.getValue());
        }
    }
}
