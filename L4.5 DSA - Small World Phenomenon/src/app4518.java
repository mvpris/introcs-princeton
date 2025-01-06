import java.awt.*;

public class app4518 {
    public static void main(String[] args) {
        GraphT graph = RingGraphGenerator.generateGraphEvenOdd(1000);
        int n = 30;     // number of random edge (shortcuts) to be added
        double E = 0.0;
        StdDraw.setXscale(0, n + 1);
        StdDraw.setYscale(0, 130);
        StdDraw.setFont(new Font("smallFont", Font.PLAIN, 6));
        for (int i = 0; i < n; i++) {
            String r1 = "" + StdRandom.uniformInt(1000);
            String r2 = "" + StdRandom.uniformInt(1000);
            while (graph.hasEdge(r1, r2) || r1.equals(r2)) {
                r1 = "" + StdRandom.uniformInt(1000);
                r2 = "" + StdRandom.uniformInt(1000);
            }
            graph.addEdge(r1, r2);
            E++;
            double averagePathLength = SmallWorldT.averagePathLength(graph);
            StdDraw.text(E, averagePathLength, String.format("%.1f", averagePathLength));
        }
    }
}
