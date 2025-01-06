public class MooresLaw {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double increase = Math.pow(2, (12.0 / n) * 10);
        System.out.println("If microprocessors double every " + n +
                " months, the increase in processor speed over a decade will be " + increase + " times.");
    }
}
