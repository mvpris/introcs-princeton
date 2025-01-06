public class LoadBalance {
    public static void main(String[] args) {
//        Assign n items to m servers, using shortest-in-a-sample policy.
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int size = Integer.parseInt(args[2]);

//        Create server queues.
        RandomQueue<Queue<Integer>> servers = new RandomQueue<Queue<Integer>>();

        for (int i = 0; i < m; i++) servers.enqueue(new Queue<Integer>());

        for (int j = 0; j < n; j++) { // Assign an item to a server.
            Queue<Integer> min = servers.sample();
            for (int k = 1; k < size; k++) { // Pick a random server, update if new min.
                Queue<Integer> queue = servers.sample();
                if (queue.size() < min.size()) min = queue;
            }
//            min is the shortest server queue.
            min.enqueue(j);
        }

        int i = 0;
        double[] lengths = new double[m];
        for (Queue<Integer> queue : servers)
            lengths[i++] = queue.size();
        StdDraw.setYscale(0, 2.0 * n / m);
        StdStats.plotBars(lengths);
    }
}
