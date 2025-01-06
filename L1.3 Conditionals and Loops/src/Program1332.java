public class Program1332 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            long power = (long) Math.pow(k, i);
            System.out.println(power);
            if (power == Long.MAX_VALUE) break;
        }
    }
}
