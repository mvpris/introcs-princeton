public class SubwayGraph {
    private final GraphT graph;

    public SubwayGraph(String filename, String delimiter) {
        graph = new GraphT(filename, delimiter);

    }

    public Iterable<String> shortestPath(String v, String w) {
        if (graph.hasVertex(v)) {
            PathFinderT pf = new PathFinderT(graph, v);
            if (pf.isReachable(w)) return pf.pathTo(w);
        }
        throw new IllegalArgumentException("Station is invalid");
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        SubwayGraph subwayGraph = new SubwayGraph(filename, delimiter);
        StdOut.println("Please provide departure and arrival stations:");
        while (!StdIn.isEmpty()) {
            String[] stations = StdIn.readLine().split(delimiter);
            StdOut.println("Shortest path between the two stations is:");
            StdOut.println(subwayGraph.shortestPath(stations[0], stations[1]) + "\n");
            StdOut.println("Please provide departure and arrival stations");
            // input: java SubwayGraph tokyo.txt " "
            // E21 E09
        }
    }
}
