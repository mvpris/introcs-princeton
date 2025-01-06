public class HollywoodNumbers {
    private final GraphT graph;
    private final ST<String, Double> hollywoodNumbers = new ST<>();

    public HollywoodNumbers(GraphT graph) {
        this.graph = graph;
        computeHollywoodNumbers();
    }

    private void computeHollywoodNumbers() {
        for (String v : graph.vertices()) {
            hollywoodNumbers.put(v, averagePathLength(v));
        }
    }

    private double averagePathLength(String s) {
        Queue<String> queue = new Queue<>();
        SET<String> visited = new SET<>();
        ST<String, Integer> distTo = new ST<>();
        int totalDistance = 0;
        int count = 0;

        queue.enqueue(s);
        visited.add(s);
        distTo.put(s, 0);

        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            int dist = distTo.get(v);

            for (String w : graph.adjacentTo(v)) {
                if (!visited.contains(w)) {
                    queue.enqueue(w);
                    visited.add(w);
                    distTo.put(w, dist + 1);
                    totalDistance += dist + 1;
                    count++;
                }
            }
        }

        if (count == 0) return Double.POSITIVE_INFINITY;
        return (double) totalDistance / count;
    }

    public double getHollywoodNumber(String performer) {
        return hollywoodNumbers.get(performer);
    }

    public String findBestHollywoodNumber() {
        String bestPerformer = null;
        double bestNumber = Double.POSITIVE_INFINITY;

        for (String performer : hollywoodNumbers.keys()) {
            double number = hollywoodNumbers.get(performer);
            if (number < bestNumber) {
                bestNumber = number;
                bestPerformer = performer;
            }
        }
        return bestPerformer;
    }

    public String findWorstHollywoodNumber() {
        String worstPerfomer = null;
        double worstNumber = Double.NEGATIVE_INFINITY;
        for (String performer : hollywoodNumbers.keys()) {
            double number = hollywoodNumbers.get(performer);
            if (number > worstNumber) {
                worstNumber = number;
                worstPerfomer = performer;
            }
        }
        return worstPerfomer;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT graph = new GraphT(filename, delimiter);
        HollywoodNumbers hollywoodNumbers = new HollywoodNumbers(graph);

        String kevinBacon = "Bacon, Kevin";

        if (graph.hasVertex(kevinBacon)) {
            double kevinBaconNumber = hollywoodNumbers.getHollywoodNumber(kevinBacon);
            StdOut.printf("Kevin Bacon's Hollywood number: %.2f\n", kevinBaconNumber);

            String bestPerformer = hollywoodNumbers.findBestHollywoodNumber();
            String worstPerformer = hollywoodNumbers.findWorstHollywoodNumber();
            StdOut.printf("Performer with best Hollywood number: %s (%.2f)\n",
                    bestPerformer, hollywoodNumbers.getHollywoodNumber(bestPerformer));
            StdOut.printf("Performer with worst Hollywood number: %s (%.2f)\n",
                    worstPerformer, hollywoodNumbers.getHollywoodNumber(worstPerformer));
        } else {
            StdOut.println("Kevin Bacon is not in the graph.");
        }
    }
}
