import java.util.ArrayList;
import java.util.List;

public class SmallWorldT {
    public static double averageDegree(GraphT G) {
        return 2.0 * G.E() / G.V();
    }

    public static double averagePathLength(GraphT G) {
        int sum = 0;
        for (String v : G.vertices()) {
            PathFinderT pf = new PathFinderT(G, v);
            for (String w : G.vertices()) {
                sum += pf.distanceTo(w);
            }
        }
        return (double) sum / (G.V() * (G.V() - 1));
    }

    public static double clusteringCoefficient(GraphT G) {
        double total = 0.0;
        for (String v : G.vertices()) {
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
        return total / G.V();
    }

    public static double globalClusteringCoefficient(GraphT G) {
        int triangles = 0;
        int triplets = 0;

        for (String v : G.vertices()) {
            List<String> neighbors = new ArrayList<>();
            for (String w : G.adjacentTo(v)) {
                neighbors.add(w);
            }

            for (int i = 0; i < neighbors.size(); i++) {
                for (int j = i + 1; j < neighbors.size(); j++) {
                    triplets++;
                    if (G.hasEdge(neighbors.get(i), neighbors.get(j))) {
                        triangles++;
                    }
                }
            }
        }
        if (triplets == 0) return 0;
        return (double) triangles / triplets;
    }

    public static double clusteringCoefficient(GraphT G, int k) {
        double total = 0.0;

        for (String v : G.vertices()) {
            SET<String> localVertices = new SET<>();
            Queue<String> queue = new Queue<>();
            ST<String, Integer> dist = new ST<>();
            queue.enqueue(v);
            dist.put(v, 0);

            // BFS to find all vertices within distance k
            while (!queue.isEmpty()) {
                String current = queue.dequeue();
                int currentDist = dist.get(current);
                if (currentDist < k) {
                    for (String neighbor : G.adjacentTo(current)) {
                        if (!dist.contains(neighbor)) {
                            dist.put(neighbor, currentDist + 1);
                            queue.enqueue(neighbor);
                            localVertices.add(neighbor);
                        }
                    }
                }
            }

            // Calculate the local clustering coefficient
            int possibleEdges = 0;
            int actualEdges = 0;
            List<String> vertexList = new ArrayList<>();

            for (String u : localVertices) {
                vertexList.add(u);
            }

            for (int i = 0; i < vertexList.size(); i++) {
                for (int j = i + 1; j < vertexList.size(); j++) {
                    if (G.hasEdge(vertexList.get(i), vertexList.get(j))) {
                        actualEdges++;
                    }
                    possibleEdges++;
                }
            }

            if (possibleEdges > 0) {
                total += (double) actualEdges / possibleEdges;
            }
        }

        return total / G.V();
    }

    public static boolean isSmallWorld(GraphT G) {
        return averageDegree(G) < (20 * (Math.log(G.V()) / Math.log(2))) &&
                averagePathLength(G) < (10 * (Math.log(G.V()) / Math.log(2))) &&
                clusteringCoefficient(G) > 0.1;
    }

    public static boolean isSmallWorld(GraphT G,
                                       double averageDegree,
                                       double averagePathLength,
                                       double clusteringCoefficient) {
        return averageDegree < (20 * (Math.log(G.V()) / Math.log(2))) &&
                averagePathLength < (10 * (Math.log(G.V()) / Math.log(2))) &&
                clusteringCoefficient > 0.1;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT graph = new GraphT(filename, delimiter);

        double averageDegree = averageDegree(graph);
        double averagePathLength = averagePathLength(graph);
        double clusteringCoefficient = clusteringCoefficient(graph);
        double globalClusteringCoefficient = globalClusteringCoefficient(graph);

        StdOut.printf("number of vertices     = %7d\n", graph.V());
        StdOut.printf("number of edges        = %7d\n", graph.E());
        StdOut.printf("average degree         = %7.3f\n", averageDegree);
        StdOut.printf("average path length    = %7.3f\n", averagePathLength);
        StdOut.printf("clustering coefficient = %7.3f\n", clusteringCoefficient);
        StdOut.printf("global clustering coefficient = %7.3f\n", globalClusteringCoefficient);
//        StdOut.printf("clustering coefficient (k=1) = %7.3f\n", clusteringCoefficient(graph, 1)); // app4519
//        StdOut.printf("clustering coefficient (k=2) = %7.3f\n", clusteringCoefficient(graph, 2)); // app4519
        StdOut.println("is graph small world graph? " + isSmallWorld(graph, averageDegree,
                averagePathLength, clusteringCoefficient));

//        graph.addEdge("" + StdRandom.uniformInt(1000), "" + StdRandom.uniformInt(1000));
//        graph.addEdge("0", "499");
//        StdOut.println("edge added at antipodal vertices 0 and 499");
//        StdOut.println("is graph small world graph after random edge added (0,499)? " + isSmallWorld(graph,
//                averageDegree, averagePathLength, clusteringCoefficient));

        // input: java SmallWorldT G1000EO.txt " "
        // input: java SmallWorldT G1000random.txt " "
        // input: java SmallWorldT G1000EOR.txt " "
    }
}
