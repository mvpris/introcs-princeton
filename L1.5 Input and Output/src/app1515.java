public class app1515 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        double min = Double.MAX_VALUE;
        int xif = 0;
        int yif = 0;
        int zif = 0;
        while (!StdIn.isEmpty()) {
            int xi = StdIn.readInt();
            int yi = StdIn.readInt();
            int zi = StdIn.readInt();
            double d = Math.pow(x - xi, 2) + Math.pow(y - yi, 2) + Math.pow(z - zi, 2);
            if (d < min) {
                min = d;
                xif = xi;
                yif = yi;
                zif = zi;
            }
        }
        StdOut.println("d= " + min);
        StdOut.println("xi= " + xif + " yi= " + yif + " zi= " + zif);
    }
}
