public class CoverTime {
    public static int coverTime(GraphT G, String start) {
        SET<String> visited = new SET<>();
        String current = start;
        int steps = 0;

        while (visited.size() < G.V()) {
            visited.add(current);
            String[] neighbors = new String[G.degree(current)];
            int i = 0;
            for (String neighbor : G.adjacentTo(current)) {
                neighbors[i++] = neighbor;
            }
            current = neighbors[StdRandom.uniformInt(neighbors.length)];
            steps++;
        }
        return steps;
    }

    public static GraphT createCompleteGraph(int V) {
        GraphT G = new GraphT();
        for (int i = 0; i < V; i++) {
            G.addVertex(String.valueOf(i));
            for (int j = 0; j < i; j++) {
                G.addEdge(String.valueOf(i), String.valueOf(j));
            }
        }
        return G;
    }

    public static double simulate(GraphT G, int trials) {
        int totalSteps = 0;
        for (int i = 0; i < trials; i++) {
            totalSteps += coverTime(G, "0");
        }
        return (double) totalSteps / trials;
    }

    public static void main(String[] args) {
        int V = 250;
        int trials = 1000;
        GraphT completeGraph = createCompleteGraph(V);
        GraphT ringGraph2 = RingKGraphGenerator.generateKRingGraph(V, 2);
        GraphT ringGraph2Shortcuts = RingKGraphGenerator.generateKRingGraphWithShortcuts(V, 2, 10);
        GraphT ringGraph3 = RingKGraphGenerator.generateKRingGraph(V, 3);
        double completeGraphSteps = simulate(completeGraph, trials);
        double ringGraph2Steps = simulate(ringGraph2, trials);
        double ringGraph2ShortcutsSteps = simulate(ringGraph2Shortcuts, trials);
        double ringGraph3Steps = simulate(ringGraph3, trials);
        StdOut.println("Estimated cover time for complete graph: " + completeGraphSteps);
        StdOut.println("Estimated cover time for ring graph k=2: " + ringGraph2Steps);
        StdOut.println("Estimated cover time for ring graph k=2 with 10 shortcuts: " + ringGraph2ShortcutsSteps);
        StdOut.println("Estimated cover time for ring graph k=3: " + ringGraph3Steps);
        // hypothesis: complete graph steps proportional to V*log(V), ring graph steps ~ V^2,
        // V^3: graphs with dense regions and sparse connections
        // 2^V: hypercube graphs and other highly connected structures
    }
}
