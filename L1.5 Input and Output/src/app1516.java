public class app1516 {
    public static void main(String[] args) {
        int m = 0;
        double xSum = 0;
        double ySum = 0;
        while (!StdIn.isEmpty()) {
            int xi = StdIn.readInt();
            int yi = StdIn.readInt();
            int mi = StdIn.readInt();
            m += mi;
            xSum += mi * xi;
            ySum += mi * yi;
        }
        double x = xSum / m;
        double y = ySum / m;
        StdOut.println("(x,y,m)=" + "(" + x + "," + y + "," + m + ")");
    }
}
