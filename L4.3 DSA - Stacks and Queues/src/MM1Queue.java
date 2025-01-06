public class MM1Queue {
    public static void main(String[] args) {
        double lambda = Double.parseDouble(args[0]);
        double mu = Double.parseDouble(args[1]);
        Histogram hist = new Histogram(60 + 1);
        Queue<Double> queue = new Queue<>();
        double nextArrival = StdRandom.exponential(lambda);
        double nextService = nextArrival + StdRandom.exponential(mu);
        StdDraw.enableDoubleBuffering();

        while (true) {
            // Simulate arrivals before next service.
            while (nextArrival < nextService) {
                queue.enqueue(nextArrival);
                nextArrival += StdRandom.exponential(lambda);
            }

            // Simulate next service.
            double wait = nextService - queue.dequeue();
            hist.addDataPoint(Math.min(60, (int) Math.round(wait)));
            StdDraw.clear();
            hist.draw();
            StdDraw.show();
            StdDraw.pause(20);
            if (queue.isEmpty())
                nextService = nextArrival + StdRandom.exponential(mu);
            else
                nextService = nextService + StdRandom.exponential(mu);
        }
//        java MM1Queue 0.167 0.25 // service rate is significantly higher than arrival rate -> long wait times are rare
//        java MM1Queue 0.167 0.20 // service rate is too close to arrival rate -> long wait times are common
    }
}
