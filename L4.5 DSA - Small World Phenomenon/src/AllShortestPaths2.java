public class AllShortestPaths2 {
    private final ST<String, PathFinderT> pfs;

    public AllShortestPaths2(GraphT G) {
        pfs = new ST<>();
        for (String v : G.vertices()) {
            pfs.put(v, new PathFinderT(G, v));
        }
    }

    public Iterable<String> verticesASP(String v, String w) {
        return pfs.get(v).pathTo(w);
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter1 = args[1];
        String delimiter2 = args[2];
        GraphT G = new GraphT(filename, delimiter1);

        AllShortestPaths2 asp = new AllShortestPaths2(G);

        while (StdIn.hasNextLine()) {
            String query = StdIn.readLine();
            String[] queries = query.split(delimiter2);
            for (String v : asp.verticesASP(queries[0], queries[1])) {
                StdOut.println("   " + v);
            }
        }
        // input: java AllShortestPaths2 routes.txt " " "--"
        // JFK--LAX
    }
}
