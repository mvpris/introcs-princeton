public class ConnectedGraphGenerator {
    public static GraphT generateConnectedGraph(int n) {
        GraphT graph = new GraphT();
        String v, w;
        SET<String> set = new SET<>();

        for (int i = 0; i < n; i++) {
            v = "" + i;
            w = "" + StdRandom.uniformInt(n);
            while (set.contains(v + " " + w) || set.contains(w + " " + v) || v.equals(w)) {
                w = "" + StdRandom.uniformInt(n);
            }
            set.add(v + " " + w);
            set.add(w + " " + v);
            graph.addEdge(v, w);
        }

        int randoms = StdRandom.uniformInt(n);
        StdOut.println(randoms);
        for (int i = 0; i < randoms; i++) {
            v = "" + StdRandom.uniformInt(n);
            w = "" + StdRandom.uniformInt(n);
            while (graph.hasEdge(v, w) || v.equals(w)) {
                v = "" + StdRandom.uniformInt(n);
                w = "" + StdRandom.uniformInt(n);
            }
            graph.addEdge(v, w);
        }
        return graph;
    }

    public static void main(String[] args) {
        GraphT G = generateConnectedGraph(1000);
        G.toFile("G1000connected.txt");
        StdOut.printf("number of vertices     = %7d\n", G.V());
        StdOut.printf("number of edges        = %7d\n", G.E());
        StdOut.printf("average degree         = %7.3f\n", SmallWorldT.averageDegree(G));
        StdOut.printf("average path length    = %7.3f\n", SmallWorldT.averagePathLength(G));
        StdOut.printf("clustering coefficient = %7.3f\n", SmallWorldT.clusteringCoefficient(G));
        StdOut.println("is G small world G? " + SmallWorldT.isSmallWorld(G));
    }
}
