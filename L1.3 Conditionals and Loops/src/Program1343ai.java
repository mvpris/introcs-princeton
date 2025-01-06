public class Program1343ai {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        int e = Integer.parseInt(args[4]);

        int median;
        if ((a < b && b < c) || (c < b && b < a))
            median = b;
        else if ((b < a && a < c) || (c < a && a < b))
            median = a;
        else if ((a < c && c < b) || (b < c && c < a))
            median = c;
        else if ((a < d && d < b) || (b < d && d < a))
            median = d;
        else
            median = e;
        System.out.println("Median value: " + median);
    }
}
