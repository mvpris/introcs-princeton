public class app1530 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        double div = (hi - lo) / n;
        int[] count = new int[n];
        while (!StdIn.isEmpty()) {
            double num = StdIn.readDouble();
            for (int i = 1; i <= n; i++) {
                if (num > lo && num < hi && num < i * div + lo && num > i * div) count[i - 1]++;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) max = count[i];
        }
        for (int i = 0; i < n; i++) {
            StdOut.print(count[i] + " ");
        }
        StdOut.println();
        int canvasWidth = 500;
        int canvasHeight = 500;
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, max);
        for (int i = 0; i < n; i++) {
            StdDraw.filledRectangle(0.5 + i, count[i] / 2.0, 0.5, count[i] / 2.0);
        }
        StdDraw.show();
    }
}
