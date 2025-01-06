public class MD1Queue {
    public static void main(String[] args) {
        double lambda = Double.parseDouble(args[0]);
        double mu = Double.parseDouble(args[1]);
        Histogram hist = new Histogram(60 + 1);
        Queue<Double> queue = new Queue<>();
        double nextArrival = StdRandom.exponential(lambda);
        double nextService = nextArrival + 1 / mu;
        StdDraw.enableDoubleBuffering();

        double totalWaitTime = 0;
        int totalCustomers = 0;

        while (true) {
            // Simulate arrivals before next service.
            while (nextArrival < nextService) {
                queue.enqueue(nextArrival);
                nextArrival += StdRandom.exponential(lambda);
            }

            // Simulate next service.
            double arrivalTime = queue.dequeue();
            double wait = nextService - arrivalTime;
            totalWaitTime += wait;
            totalCustomers++;
            hist.addDataPoint(Math.min(60, (int) Math.round(wait)));
            StdDraw.clear();
            hist.draw();
            StdDraw.show();
            StdDraw.pause(20);
            if (queue.isEmpty())
                nextService = nextArrival + 1 / mu; // Fixed service time
            else
                nextService = nextService + 1 / mu; // Fixed service time

            // Print Little's Law verification periodically
            if (totalCustomers % 200 == 0) {
                double averageWaitTime = totalWaitTime / totalCustomers;
                double averageNumberInSystem = lambda * averageWaitTime;
                StdOut.println("Average number in system (L): " + averageNumberInSystem);
                StdOut.println("Average wait time (W): " + averageWaitTime);
                StdOut.println("Arrival rate (lambda): " + lambda);
                StdOut.println("Little's Law (L = lambda*W): " + (lambda * averageWaitTime));
                StdOut.println();
            }
        }
    }
}

