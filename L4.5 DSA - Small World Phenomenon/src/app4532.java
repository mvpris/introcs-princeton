public class app4532 {
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

        Stopwatch s1 = new Stopwatch();
        StdOut.println("Performer-Performer graph stats:");
        StdOut.printf("number of vertices     = %7d\n", G.V());
        StdOut.printf("number of edges        = %7d\n", G.E());
        StdOut.printf("average degree         = %7.3f\n", SmallWorldT.averageDegree(G));
        StdOut.printf("average path length    = %7.3f\n", SmallWorldT.averagePathLength(G));
        StdOut.printf("clustering coefficient = %7.3f\n", SmallWorldT.clusteringCoefficient(G));
//        StdOut.println("is graph small world graph? " + SmallWorldT.isSmallWorld(G));

        double elapsed1 = s1.elapsedTime();
        StdOut.println("time elapsed for performer-performer = " + elapsed1 + " seconds\n");

        GraphT G2 = new GraphT(filename, delimiter);

        Stopwatch s2 = new Stopwatch();
        StdOut.println("Movie-Performer graph stats:");
        StdOut.printf("number of vertices     = %7d\n", G2.V());
        StdOut.printf("number of edges        = %7d\n", G2.E());
        StdOut.printf("average degree         = %7.3f\n", SmallWorldT.averageDegree(G2));
        StdOut.printf("average path length    = %7.3f\n", SmallWorldT.averagePathLength(G2));
        StdOut.printf("clustering coefficient = %7.3f\n", SmallWorldT.clusteringCoefficient(G2));

        double elapsed2 = s2.elapsedTime();
        StdOut.println("time elapsed for movie-performer = " + elapsed2 + " seconds");

        // input: java app4532 moviesGhalved.txt "//"
    }
}
