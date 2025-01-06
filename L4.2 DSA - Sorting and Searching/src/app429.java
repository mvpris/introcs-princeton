public class app429 {
    public static double inverseFunction(ffunction f, double y) {
        return bisectionSearch(f, y, 0.00000001, -8, 8);
    }

    private static double bisectionSearch(ffunction f, double y, double delta, double lo, double hi) {
        double mid = lo + (hi - lo) / 2;
        if (hi - lo < delta) return mid;
        else if (f.evaluate(mid) > y) return bisectionSearch(f, y, delta, lo, mid);
        else return bisectionSearch(f, y, delta, mid, hi);
    }

    public static void main(String[] args) {
        double z = Double.parseDouble(args[0]);

        ffunction fSquare = x -> x * x;
        double ySquare = fSquare.evaluate(z);
        StdOut.printf("z = %.10f\n", inverseFunction(fSquare, ySquare));
        StdOut.printf("fSquare.evaluate(z) = %.10f\n", fSquare.evaluate(z));

        ffunction fgPDFlambda = x -> Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
        double ygPDFlambda = fgPDFlambda.evaluate(z);
        StdOut.printf("z = %.10f\n", inverseFunction(fgPDFlambda, ygPDFlambda));
        StdOut.printf("fgPDFlambda.evaluate(z) = %.10f\n", fgPDFlambda.evaluate(z));

        ffunction fgPDF = new gPDF();
        double ygPDF = fgPDF.evaluate(z);
        StdOut.printf("z = %.10f\n", inverseFunction(fgPDF, ygPDF));
        StdOut.printf("fgPDF.evaluate(z) = %.10f\n", fgPDF.evaluate(z));

        ffunction fgCDF = new gCDF();
        double ygCDF = fgCDF.evaluate(z);
        StdOut.printf("z = %.10f\n", inverseFunction(fgCDF, ygCDF));
        StdOut.printf("fgCDF.evaluate(z) = %.10f\n", fgCDF.evaluate(z));

//        .../src> java app429lambda 3
//        z = 3.0000000037
//        fSquare.evaluate(z) = 9.0000000000
//        z = -2.9999999963
//        fgPDFlambda.evaluate(z) = 0.0044318484
//        z = -2.9999999963
//        fgPDF.evaluate(z) = 0.0044318484
//        z = 3.0000000037
//        fgCDF.evaluate(z) = 0.9986501020

    }
}
