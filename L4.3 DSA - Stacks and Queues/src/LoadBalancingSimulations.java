public class LoadBalancingSimulations {
    public static void main(String[] args) {
        int m = 100000;
        int n = 1000000;
        int[] sizes = {1, 2, 3, 4};

        for (int size : sizes) {
            double totalMaxLength = 0;
            for (int trial = 0; trial < 100; trial++) {
                RandomQueue<Queue<Integer>> servers = new RandomQueue<Queue<Integer>>();
                for (int i = 0; i < m; i++) servers.enqueue(new Queue<Integer>());

                for (int j = 0; j < n; j++) {
                    Queue<Integer> min = servers.sample();
                    for (int k = 1; k < size; k++) {
                        Queue<Integer> queue = servers.sample();
                        if (queue.size() < min.size()) min = queue;
                    }
                    min.enqueue(j);
                }

                int maxLength = 0;
                for (Queue<Integer> queue : servers) {
                    int length = queue.size();
                    if (length > maxLength) maxLength = length;
                }
                totalMaxLength += maxLength;
            }
            double averageMaxLength = totalMaxLength / 100;
            StdOut.println("Average maximum queue length for sample size " + size + ": " + averageMaxLength);

//            .../src> java LoadBalancingSimulations
//            Average maximum queue length for sample size 1: 26.65
//            Average maximum queue length for sample size 2: 13.0
//            Average maximum queue length for sample size 3: 12.0
//            Average maximum queue length for sample size 4: 11.95
//  Yes, results shows that taking a sample size of 2 achieves near perfect balancing, so no point taking larger samples
        }
    }
}
