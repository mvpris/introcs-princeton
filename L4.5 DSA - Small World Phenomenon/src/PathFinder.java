public class PathFinder {
    // prev[v] = previous vertex on shortest path from s to v
    // dist[v] = length of shortest path from s to v
    private ST<String, String> prev = new ST<>();
    private ST<String, Integer> dist = new ST<>();

    // run BFS in graph G from given source vertex s
    public PathFinder(Graph G, String s) {

        // put source on the queue
        Queue2<String> queue = new Queue2<>();
        queue.enqueue(s);
        dist.put(s, 0);

        // repeated remove next vertex v from queue and insert
        // all its neighbors, provided they haven't yet been visited
        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            for (String w : G.adjacentTo(v)) {
                if (!dist.contains(w)) {
                    queue.enqueue(w);
                    dist.put(w, 1 + dist.get(v));
                    prev.put(w, v);
                }
            }
        }
    }

    // is v reachable from the source s?
    public boolean hasPathTo(String v) {
        return dist.contains(v);
    }

    // return the length of the shortest path from v to s
    public int distanceTo(String v) {
        if (!hasPathTo(v)) return Integer.MAX_VALUE;
        return dist.get(v);
    }

    // return the shortest path from v to s as an Iterable
    public Iterable<String> pathTo(String v) {
        Stack2<String> path = new Stack2<>();
        while (v != null && dist.contains(v)) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        Graph G = new Graph(filename, delimiter);
        String s = args[2];
        PathFinder pf = new PathFinder(G, s);
        while (!StdIn.isEmpty()) {
            String t = StdIn.readLine();
            for (String v : pf.pathTo(t)) {
                StdOut.println("   " + v);
            }
            StdOut.println("distance " + pf.distanceTo(t));
        }
    }
}
