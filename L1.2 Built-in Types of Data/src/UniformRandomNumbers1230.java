public class UniformRandomNumbers1230 {
    public static void main(String[] args) {
        double a1 = Math.random();
        double a2 = Math.random();
        double a3 = Math.random();
        double a4 = Math.random();
        double a5 = Math.random();
        double average = (a1 + a2 + a3 + a4 + a5) / 5;
        double min1 = Math.min(a1, a2);
        double min2 = Math.min(a3, a4);
        double min3 = Math.min(min1, min2);
        double min4 = Math.min(min3, a5);
        double max1 = Math.max(a1, a2);
        double max2 = Math.max(a3, a4);
        double max3 = Math.max(max1, max2);
        double max4 = Math.max(max3, a5);
        System.out.println("Average=" + average);
        System.out.println("Minimum=" + min4);
        System.out.println("Maximum=" + max4);
    }
}
