public class app4525 {
    public static void main(String[] args) {
        double avDegreeRandom = 0.0, avPathLRandom = 0.0, clusterCRandom = 0.0;
        double avDegree2Ring = 0.0, avPathL2Ring = 0.0, clusterC2Ring = 0.0;

        int m = 500, n = 1000;
        double p = 0.01;
        for (int i = 0; i < m; i++) {
            GraphT randomG = ConnectedRandomGraphGenerator.generateRandomGraph(n, p);
            GraphT ringG = RingGraphGenerator.generateGraphEvenOdd(n);
            RingGraphGenerator.addRandomShortcuts(ringG, n / 2);
        }
    }
}
