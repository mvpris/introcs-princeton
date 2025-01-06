public class PathFinderGeneric<Vertex extends Comparable<Vertex>> {
    private final ST<Vertex, Integer> dist;
    private final ST<Vertex, Vertex> prev;

    public PathFinderGeneric(GraphGeneric<Vertex> G, Vertex s) {
        dist = new ST<>();
        prev = new ST<>();

        Queue<Vertex> queue = new Queue<>();
        queue.enqueue(s);
        dist.put(s, 0);

        while (!queue.isEmpty()) {
            Vertex v = queue.dequeue();
            for (Vertex w : G.adjacentTo(v)) {
                if (!dist.contains(w)) {
                    queue.enqueue(w);
                    dist.put(w, dist.get(v) + 1);
                    prev.put(w, v);
                }
            }
        }
    }

    public int distanceTo(Vertex v) {
        return dist.get(v);
    }

    public Iterable<Vertex> pathTo(Vertex v) {
        Stack<Vertex> path = new Stack<>();
        while (v != null && prev.contains(v)) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphGeneric<String> G = new GraphGeneric<>(filename, delimiter);
        String s = args[2];
        PathFinderGeneric<String> pf = new PathFinderGeneric<>(G, s);

        while (StdIn.hasNextLine()) {
            String t = StdIn.readLine();
            int d = pf.distanceTo(t);
            for (String v : pf.pathTo(t)) {
                StdOut.println("   " + v);
            }
            StdOut.println("distance " + d);
        }
    }
}
