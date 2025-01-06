public class app1618 {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]); // java Transition < tinyG.txt | java app1618 1000 1000000
        int x = Integer.parseInt(args[1]);
        int n = StdIn.readInt();
        StdIn.readInt();

        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();

        int totalSteps = 0;

        for (int q = 0; q < n; q++) {
            for (int k = 0; k < x; k++) {

                int page = q;
                boolean[] pageVisited = new boolean[n];
                boolean exitFlag = false;
                int steps = 0;

                for (int t = 0; t < trials; t++) {
                    double r = Math.random();
                    double sum = 0.0;

                    for (int j = 0; j < n; j++) {
                        sum += p[page][j];
                        if (r < sum) {
                            page = j;
                            pageVisited[page] = true;
                            break;
                        }
                    }
                    steps++;

                    for (int i = 0; i < n; i++) {
                        if (!pageVisited[i]) break;
                        if (i == n - 1) exitFlag = true;
                    }

                    if (exitFlag) {
                        totalSteps += steps;
                        break;
                    }
                }

            }
        }

        double coverTime = (double) totalSteps / (n * x);
        StdOut.println("Cover time= " + coverTime);
    }
}
