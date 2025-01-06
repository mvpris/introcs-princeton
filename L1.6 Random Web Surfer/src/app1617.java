import java.util.Random;

public class app1617 {
    public static void main(String[] args) {
        int numPages = 5; // Number of pages in the graph
        int numSimulations = 10000; // Number of simulations

        int[] hittingTimes = new int[numPages];
        int[][] graph = {
                {1},
                {2, 2, 3, 3, 4},
                {3},
                {0},
                {0, 2}
        };

        Random random = new Random();

        for (int i = 0; i < numSimulations; i++) {
            int currentPage = random.nextInt(numPages); // Start from a random page
            int moves = 0;

            while (true) {
                int nextPage = graph[currentPage][random.nextInt(graph[currentPage].length)];
                moves++;

                if (nextPage == 0) { // The surfer has reached the target page (Page 0)
                    hittingTimes[currentPage] += moves;
                    break;
                }

                currentPage = nextPage;
            }
        }

        for (int page = 0; page < numPages; page++) {
            double averageHittingTime = (double) hittingTimes[page] / numSimulations;
            System.out.printf("Page %d: Estimated Hitting Time = %.2f\n", page, averageHittingTime);
        }
    }
}
