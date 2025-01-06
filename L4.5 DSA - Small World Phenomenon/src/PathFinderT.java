public class PathFinderT {
    private final ST<String, Integer> dist;
    private final ST<String, String> prev;

    public PathFinderT(GraphT G, String s) {
        dist = new ST<>();
        prev = new ST<>();

        Queue<String> queue = new Queue<>();
        queue.enqueue(s);
        dist.put(s, 0);

        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            for (String w : G.adjacentTo(v)) {
                if (!dist.contains(w)) {
                    queue.enqueue(w);
                    dist.put(w, dist.get(v) + 1);
                    prev.put(w, v);
                }
            }
        }
    }

    public boolean isReachable(String v) {
        return dist.contains(v);
    }

    public int distanceTo(String v) {
        if (!isReachable(v)) return Integer.MAX_VALUE;
        return dist.get(v);
    }

    public Iterable<String> pathTo(String v) {
        Stack<String> path = new Stack<>();
        while (v != null && dist.contains(v)) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }

    public Iterable<String> vertices() {
        Queue<String> queue = new Queue<>();
        for (String v : dist.keys()) queue.enqueue(v);
        return queue;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT G = new GraphT(filename, delimiter);
        String s = args[2];
        PathFinderT pf = new PathFinderT(G, s);

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
