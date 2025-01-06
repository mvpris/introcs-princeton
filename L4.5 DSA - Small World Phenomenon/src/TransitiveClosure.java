public class TransitiveClosure {
    private final Digraph graph;

    public TransitiveClosure(Digraph graph) {
        this.graph = graph;
    }

    public boolean isReachable(String v, String w) {
        Queue<String> queue = new Queue<>();
        SET<String> visited = new SET<>();

        queue.enqueue(v);
        visited.add(v);

        while (!queue.isEmpty()) {
            String x = queue.dequeue();

            for (String y : graph.adjacentTo(x)) {
                if (!visited.contains(y)) {
                    queue.enqueue(y);
                    visited.add(y);
                    if (y.equals(w)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph();
        G.addEdge("A", "B");
        G.addEdge("B", "C");
        G.addEdge("C", "D");
        G.addEdge("E", "F");
        TransitiveClosure tc = new TransitiveClosure(G);
        StdOut.println("Is B reachable from A: " + tc.isReachable("A", "B"));
        StdOut.println("Is D reachable from A: " + tc.isReachable("A", "D"));
        StdOut.println("Is F reachable from A: " + tc.isReachable("A", "F"));
    }
}
