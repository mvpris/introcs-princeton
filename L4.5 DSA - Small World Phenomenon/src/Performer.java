public class Performer {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT G = new GraphT();

        In in = new In(filename);

        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++)
                for (int j = i + 1; j < names.length; j++)
                    G.addEdge(names[i], names[j]);
        }

        StdOut.printf("number of vertices     = %7d\n", G.V());
        StdOut.printf("number of edges        = %7d\n", G.E());
        StdOut.printf("average degree         = %7.3f\n", SmallWorldT.averageDegree(G));
        StdOut.printf("average path length    = %7.3f\n", SmallWorldT.averagePathLength(G));
        StdOut.printf("clustering coefficient = %7.3f\n", SmallWorldT.clusteringCoefficient(G));

        // input: java Performer moviesGhalved.txt "//"
    }
}
