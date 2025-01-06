public class WattsStrogatzModel {
    public static void main(String[] args) {
        int n = 100;
        int V = 10000;
        int logV = (int) (10 * Math.log(V) / Math.log(2));
        int trials = 100;

        GraphT grid = GridGraphGenerator.generateGridGraph(n);
        StdOut.println("grid:                 complete");
        GraphT gridShortcuts = GridGraphGenerator.generateGridGraphWithShortcuts(n, n);
        StdOut.println("gridShortcuts:        complete");
        GraphT k2Ring = RingKGraphGenerator.generateKRingGraph(V, 2);
        StdOut.println("k2Ring:               complete");
        GraphT k2RingShortcuts = RingKGraphGenerator.generateKRingGraphWithShortcuts(V, 2, n);
        StdOut.println("k2RingShortcuts:      complete");
        GraphT k10logVRing = RingKGraphGenerator.generateKRingGraph(V, logV);
        StdOut.println("k10logVRing:          complete");
        GraphT k10logVRingShortcuts = RingKGraphGenerator.generateKRingGraphWithShortcuts(V, logV, n);
        StdOut.println("k10logVRingShortcuts: complete\n");

//        double aplGrid = SmallWorldT.averagePathLength(grid);
//        double aplGridShortcuts = SmallWorldT.averagePathLength(gridShortcuts);
//        double aplk2Ring = SmallWorldT.averagePathLength(k2Ring);
//        double aplk2RingShortcuts = SmallWorldT.averagePathLength(k2RingShortcuts);
//        double aplk10logVRing = SmallWorldT.averagePathLength(k10logVRing);
//        double aplk10logVRingShortcuts = SmallWorldT.averagePathLength(k10logVRingShortcuts);
//
//        StdOut.printf("average path length aplGrid                   = %7.3f\n", aplGrid);
//        StdOut.printf("average path length aplGridShortcuts          = %7.3f\n", aplGridShortcuts);
//        StdOut.printf("average path length aplk2Ring                 = %7.3f\n", aplk2Ring);
//        StdOut.printf("average path length aplk2RingShortcuts        = %7.3f\n", aplk2RingShortcuts);
//        StdOut.printf("average path length aplk10logVRing            = %7.3f\n", aplk10logVRing);
//        StdOut.printf("average path length aplk10logVRingShortcuts   = %7.3f\n\n", aplk10logVRingShortcuts);

//        double ccGrid = SmallWorldT.clusteringCoefficient(grid);
//        double ccGridShortcuts = SmallWorldT.clusteringCoefficient(gridShortcuts);
//        double cck2Ring = SmallWorldT.clusteringCoefficient(k2Ring);
//        double cck2RingShortcuts = SmallWorldT.clusteringCoefficient(k2RingShortcuts);
//        double cck10logVRing = SmallWorldT.clusteringCoefficient(k10logVRing);
//        double cck10logVRingShortcuts = SmallWorldT.clusteringCoefficient(k10logVRingShortcuts);
//
//        StdOut.printf("clustering coefficient ccGrid                   = %7.3f\n", ccGrid);
//        StdOut.printf("clustering coefficient ccGridShortcuts          = %7.3f\n", ccGridShortcuts);
//        StdOut.printf("clustering coefficient cck2Ring                 = %7.3f\n", cck2Ring);
//        StdOut.printf("clustering coefficient cck2RingShortcuts        = %7.3f\n", cck2RingShortcuts);
//        StdOut.printf("clustering coefficient cck10logVRing            = %7.3f\n", cck10logVRing);
//        StdOut.printf("clustering coefficient cck10logVRingShortcuts   = %7.3f\n", cck10logVRingShortcuts);

        double aplGrid = Sampling.estimatedAveragePathLength(grid, trials);
        double aplGridShortcuts = Sampling.estimatedAveragePathLength(gridShortcuts, trials);
        double aplk2Ring = Sampling.estimatedAveragePathLength(k2Ring, trials);
        double aplk2RingShortcuts = Sampling.estimatedAveragePathLength(k2RingShortcuts, trials);
        double aplk10logVRing = Sampling.estimatedAveragePathLength(k10logVRing, trials);
        double aplk10logVRingShortcuts = Sampling.estimatedAveragePathLength(k10logVRingShortcuts, trials);

        StdOut.printf("average path length aplGrid                   = %7.3f\n", aplGrid);
        StdOut.printf("average path length aplGridShortcuts          = %7.3f\n", aplGridShortcuts);
        StdOut.printf("average path length aplk2Ring                 = %7.3f\n", aplk2Ring);
        StdOut.printf("average path length aplk2RingShortcuts        = %7.3f\n", aplk2RingShortcuts);
        StdOut.printf("average path length aplk10logVRing            = %7.3f\n", aplk10logVRing);
        StdOut.printf("average path length aplk10logVRingShortcuts   = %7.3f\n\n", aplk10logVRingShortcuts);

        double ccGrid = Sampling.estimatedClusterCoefficient(grid, trials);
        double ccGridShortcuts = Sampling.estimatedClusterCoefficient(gridShortcuts, trials);
        double cck2Ring = Sampling.estimatedClusterCoefficient(k2Ring, trials);
        double cck2RingShortcuts = Sampling.estimatedClusterCoefficient(k2RingShortcuts, trials);
        double cck10logVRing = Sampling.estimatedClusterCoefficient(k10logVRing, trials);
        double cck10logVRingShortcuts = Sampling.estimatedClusterCoefficient(k10logVRingShortcuts, trials);

        StdOut.printf("clustering coefficient ccGrid                   = %7.3f\n", ccGrid);
        StdOut.printf("clustering coefficient ccGridShortcuts          = %7.3f\n", ccGridShortcuts);
        StdOut.printf("clustering coefficient cck2Ring                 = %7.3f\n", cck2Ring);
        StdOut.printf("clustering coefficient cck2RingShortcuts        = %7.3f\n", cck2RingShortcuts);
        StdOut.printf("clustering coefficient cck10logVRing            = %7.3f\n", cck10logVRing);
        StdOut.printf("clustering coefficient cck10logVRingShortcuts   = %7.3f\n", cck10logVRingShortcuts);

        // input: java WattsStrogatzModel
        // output:
//        average path length aplGrid                   =  65.784
//        average path length aplGridShortcuts          =  23.086
//        average path length aplk2Ring                 = 1250.250
//        average path length aplk2RingShortcuts        =  81.259
//        average path length aplk10logVRing            =  19.437
//        average path length aplk10logVRingShortcuts   =   4.441
//
//        clustering coefficient ccGrid                   =   0.000
//        clustering coefficient ccGridShortcuts          =   0.000
//        clustering coefficient cck2Ring                 =   0.500
//        clustering coefficient cck2RingShortcuts        =   0.498
//        clustering coefficient cck10logVRing            =   0.747
//        clustering coefficient cck10logVRingShortcuts   =   0.747
    }
}
