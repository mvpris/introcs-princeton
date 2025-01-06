public class app3225 {
    public static void main(String[] args) {
        double xc = Double.parseDouble(args[0]);
        double yc = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);

        Stopwatch timer1 = new Stopwatch();
        Mandelbrot3225c.computation(xc, yc, size);
        double time1 = timer1.elapsedTime();
        StdOut.printf("Mandelbrot3225c=(%.3f seconds)\n", time1);

        Stopwatch timer2 = new Stopwatch();
        Mandelbrot3225.computation(xc, yc, size);
        double time2 = timer2.elapsedTime();
        StdOut.printf("Mandelbrot3225=(%.3f seconds)\n", time2);

        double ratio = time1 / time2;
        StdOut.printf("Ratio=%.3f\n", ratio);
    }
}
