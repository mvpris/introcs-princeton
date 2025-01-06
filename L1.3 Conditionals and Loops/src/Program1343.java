public class Program1343 {
    public static void main(String[] args) {
        int x1 = Integer.parseInt(args[0]);
        int x2 = Integer.parseInt(args[1]);
        int x3 = Integer.parseInt(args[2]);
        int x4 = Integer.parseInt(args[3]);
        int x5 = Integer.parseInt(args[4]);
        int t;
        if (x1 > x2) {
            t = x1;
            x1 = x2;
            x2 = t;
        }
        if (x1 > x3) {
            t = x1;
            x1 = x3;
            x3 = t;
        }
        if (x1 > x4) {
            t = x1;
            x1 = x4;
            x4 = t;
        }
        if (x1 > x5) {
            t = x1;
            x1 = x5;
            x5 = t;
        }
        if (x2 > x3) {
            t = x2;
            x2 = x3;
            x3 = t;
        }
        if (x2 > x4) {
            t = x2;
            x2 = x4;
            x4 = t;
        }
        if (x2 > x5) {
            t = x2;
            x2 = x5;
            x5 = t;
        }
        if (x3 > x4) {
            t = x3;
            x3 = x4;
            x4 = t;
        }
        if (x3 > x5) {
            t = x3;
            x3 = x5;
            x5 = t;
        }
        if (x4 > x5) {
            t = x4;
            x4 = x5;
            x5 = t;
        }
        System.out.print(x1 + " ");
        System.out.print(x2 + " ");
        System.out.print(x3 + " ");
        System.out.print(x4 + " ");
        System.out.println(x5);
        System.out.println("Median=" + x3);
    }
}
