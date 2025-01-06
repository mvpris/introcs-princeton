public class Program1337 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int xLim = 2 * n;
        int yLim = 2 * n;
        int steps = 0;
        double r;
        while (Math.abs(x) != xLim && Math.abs(y) != yLim) {
            r = Math.random();
            if (r < 0.25) x++;
            else if (r < 0.50) x--;
            else if (r < 0.75) y++;
            else y--;
            System.out.println("(" + x + "," + y + ")");
            steps++;
        }
        System.out.println("steps=" + steps);
    }
}
