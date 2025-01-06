public class Diameter {
    private final GraphT graph;

    public Diameter(GraphT graph) {
        this.graph = graph;
    }

    public int eccentricity(String s) {
        PathFinderT pf = new PathFinderT(graph, s);
        int eccentricity = Integer.MIN_VALUE;
        for (String v : graph.vertices()) {
            int dist = pf.distanceTo(v);
            if (dist > eccentricity && dist != Integer.MAX_VALUE) {
                eccentricity = dist;
            }
        }
        return eccentricity;
    }

    public int diameter() {
        int diameter = 0;
        for (String v : graph.vertices()) {
            PathFinderT pf = new PathFinderT(graph, v);
            for (String w : graph.vertices()) {
                int dist = pf.distanceTo(w);
                if (dist != Integer.MAX_VALUE) {
                    diameter = Math.max(diameter, dist);
                }
            }
        }
        return diameter;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
//        GraphT graph = new GraphT(filename, delimiter);
        GraphT graph = new PerformerGraph(filename, delimiter).getGraph();
        Diameter diameter = new Diameter(graph);

        String vertex = "Neeson, Liam";

        int eccentricityKB = diameter.eccentricity(vertex);
        StdOut.printf("The eccentricity of %s is %d.\n", vertex, eccentricityKB);

        int graphDiameter = diameter.diameter();
        StdOut.printf("The graph diameter is %d.\n", graphDiameter);

        // input: java Diameter moviesGhalved.txt "//"
    }
}
