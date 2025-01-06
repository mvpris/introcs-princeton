public class PerformerGraph {
    private final GraphT graph;

    public PerformerGraph(String filename, String delimiter) {
        graph = new GraphT();
        In in = new In(filename);

        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++)
                for (int j = i + 1; j < names.length; j++)
                    graph.addEdge(names[i], names[j]);
        }
    }

    public GraphT getGraph() {
        return graph;
    }

    public static void main(String[] args) {

    }
}
