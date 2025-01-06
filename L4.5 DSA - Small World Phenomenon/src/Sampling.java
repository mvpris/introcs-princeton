import java.util.ArrayList;
import java.util.List;

public class Sampling {
    public static double averageDegree(GraphT G) {
        return 2.0 * G.E() / G.V();
    }

    public static double estimatedAveragePathLength(GraphT G, int trials) {
        double totalLength = 0.0;
        int count = 0;
        List<String> vertices = new ArrayList<>();

        for (String v : G.vertices()) {
            vertices.add(v);
        }

        for (int i = 0; i < trials; i++) {
            String v = vertices.get(StdRandom.uniformInt(vertices.size()));
            PathFinderT pf = new PathFinderT(G, v);
            for (String w : vertices) {
                int dist = pf.distanceTo(w);
                if (dist < Integer.MAX_VALUE) {
                    totalLength += dist;
                    count++;
                }
            }
        }
        return count == 0 ? 0 : totalLength / count;
    }

    public static double estimatedClusterCoefficient(GraphT G, int trials) {
        double total = 0.0;
        List<String> vertices = new ArrayList<>();
        for (String v : G.vertices()) {
            vertices.add(v);
        }
        for (int i = 0; i < trials; i++) {
            String v = vertices.get(StdRandom.uniformInt(vertices.size()));
            int possible = G.degree(v) * (G.degree(v) - 1);
            int actual = 0;
            for (String u : G.adjacentTo(v)) {
                for (String w : G.adjacentTo(v)) {
                    if (G.hasEdge(u, w)) actual++;
                }
            }
            if (possible > 0) {
                total += 1.0 * actual / possible;
            }
        }
        return trials == 0 ? 0 : total / trials;
    }

    public static boolean isSmallWorld(double averageDegree, double estimatedAveragePathLength,
                                       double estimatedClusterCoefficient, GraphT G, int trials) {
        return averageDegree < (20 * (Math.log(G.V()) / Math.log(2))) &&
                estimatedAveragePathLength < (10 * (Math.log(G.V()) / Math.log(2))) &&
                estimatedClusterCoefficient > 0.1;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT graph = new GraphT(filename, delimiter);
        int trials = 200;

        double averageDegree = averageDegree(graph);
        double estimatedAveragePathLength = estimatedAveragePathLength(graph, trials);
        double estimatedClusterCoefficient = estimatedClusterCoefficient(graph, trials);
        StdOut.printf("number of vertices     = %7d\n", graph.V());
        StdOut.printf("number of edges        = %7d\n", graph.E());
        StdOut.printf("average degree         = %7.3f\n", averageDegree);
        StdOut.printf("average path length    = %7.3f\n", estimatedAveragePathLength);
        StdOut.printf("clustering coefficient = %7.3f\n", estimatedClusterCoefficient);
        StdOut.println("is graph small world graph? " + isSmallWorld(averageDegree, estimatedAveragePathLength,
                estimatedClusterCoefficient, graph, trials));
        // input: java Sampling G1000EOR.txt " "
    }
}
