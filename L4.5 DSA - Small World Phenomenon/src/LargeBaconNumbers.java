public class LargeBaconNumbers {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT graph = new GraphT(filename, delimiter);
        PathFinderT pf = new PathFinderT(graph, "Bacon, Kevin");

        String maxPerformer = "";
        int maxDist = Integer.MIN_VALUE;
        for (String vertex : graph.vertices()) {
            if (!vertex.matches(".*\\(\\d{4}\\)") && pf.isReachable(vertex)) {
                int dist = pf.distanceTo(vertex);
                if (dist > maxDist) {
                    maxDist = dist;
                    maxPerformer = vertex;
                }
            }
        }

        StdOut.println("Performer " + maxPerformer + " has the largest but finite Kevin Bacon number of " + maxDist);
    }
}
