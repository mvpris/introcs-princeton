public class gCDF implements ffunction {
    public static double pdf(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    public double evaluate(double z) {
        if (z < -8.0) return 0.0;
        if (z > 8.0) return 1.0;
        double sum = 0.0;
        double term = z;
        for (int i = 3; sum != sum + term; i += 2) {
            sum = sum + term;
            term = term * z * z / i;
        }
        return 0.5 + pdf(z) * sum;
    }

    public static void main(String[] args) {
        double z = Double.parseDouble(args[0]);
        gCDF gcdfInstance = new gCDF();
        StdOut.printf("gcdfInstance.evaluate(%.10f) = %.10f\n", z, gcdfInstance.evaluate(z));

//        java gCDF 1.5683947453
//        gcdfInstance.evaluate(1.5683947453) = 0.9416054817
    }
}
