public class WindChill1225 {
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double V = Double.parseDouble(args[1]);
        double windChill = 33.74 + 0.6215 * T + (0.4275 * T - 35.75) * Math.pow(V, 0.16);
        System.out.println(windChill + " Fahrenehit");
        System.out.println((windChill - 32) * 5 / 9 + " Celsius");
    }
}
