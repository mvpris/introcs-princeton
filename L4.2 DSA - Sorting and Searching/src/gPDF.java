public class gPDF implements ffunction {
    public double evaluate(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    public static void main(String[] args) {
        double z = Double.parseDouble(args[0]);
        gPDF gpdfInstance = new gPDF();
        StdOut.printf("gpdfInstance.evaluate(%.10f) = %.10f\n", z, gpdfInstance.evaluate(z));

//        java gPDF 1.5683947453
//        gpdfInstance.evaluate(1.5683947453) = 0.1166159092
    }
}
