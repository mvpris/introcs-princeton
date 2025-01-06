public class BaconHistogram {
    public static int largestKBnumber(GraphT graph, PathFinderT pf) {
        int maxDist = Integer.MIN_VALUE;
        for (String vertex : graph.vertices()) {
            if (!vertex.matches(".*\\(\\d{4}\\)") && pf.isReachable(vertex)) {
                int dist = pf.distanceTo(vertex);
                if (dist > maxDist) {
                    maxDist = dist;
                }
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT graph = new GraphT(filename, delimiter);
        PathFinderT pf = new PathFinderT(graph, "Bacon, Kevin");

        double[] kbFreq = new double[largestKBnumber(graph, pf) + 1];
        int infCount = 0;

        for (String vertex : graph.vertices()) {
            if (!vertex.matches(".*\\(\\d{4}\\)") && pf.isReachable(vertex)) {
                int dist = pf.distanceTo(vertex);
                kbFreq[dist]++;
            }
            if (!vertex.matches(".*\\(\\d{4}\\)") && !pf.isReachable(vertex)) {
                infCount++;
            }
        }

        double max = StdStats.max(kbFreq);
        StdDraw.setYscale(0, max);
        StdStats.plotBars(kbFreq);
        for (int i = 0; i < kbFreq.length; i++) {
            StdOut.printf("Number of performers with a KB number of %2d is equal to %.0f\n", i, kbFreq[i]);
        }
        StdOut.println("Number of performers with an infinite KB number is equal to " + infCount);
    }
}
