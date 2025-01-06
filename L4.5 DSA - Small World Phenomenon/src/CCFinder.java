public class CCFinder {
    private final GraphT graph;
    private final ST<String, Integer> componentIDs;
    private int componentCount;

    public CCFinder(GraphT graph) {
        this.graph = graph;
        this.componentIDs = new ST<>();
        this.componentCount = 0;
        computeConnectedComponents();
    }

    private void computeConnectedComponents() {
        SET<String> visited = new SET<>();
        for (String vertex : graph.vertices()) {
            if (!visited.contains(vertex)) {
                bfs(vertex, componentCount, visited);
                componentCount++;
            }
        }
    }

    private void bfs(String start, int componentID, SET<String> visited) {
        Queue<String> queue = new Queue<>();
        queue.enqueue(start);
        visited.add(start);
        componentIDs.put(start, componentID);

        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            for (String w : graph.adjacentTo(v)) {
                if (!visited.contains(w)) {
                    queue.enqueue(w);
                    visited.add(w);
                    componentIDs.put(w, componentID);
                }
            }
        }
    }

    public boolean areConnected(String v, String w) {
        validateVertex(v);
        validateVertex(w);
        return componentIDs.get(v).equals(componentIDs.get(w));
    }

    public int components() {
        return componentCount;
    }

    private void validateVertex(String v) {
        if (!graph.hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT graph = new GraphT(filename, delimiter);
        CCFinder ccFinder = new CCFinder(graph);

        StdOut.printf("Number of connected components: %d\n", ccFinder.components());
//        StdOut.printf("Are 'JFK' and 'ATL' connected? %b\n", ccFinder.areConnected("JFK", "ATL"));
//        StdOut.printf("Are 'JFK' and 'PHX' connected? %b\n", ccFinder.areConnected("JFK", "PHX"));
    }
}

