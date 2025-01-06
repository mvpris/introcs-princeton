public class app2133 {
    public static int digit(int n) {
        while (n > 9) {
            n /= 10;
        }
        return n;
    }

    public static int randomDist() {
        int random = (int) (Math.random() * 9) + 1;
        return random;
    }

    public static void main(String[] args) {
        int[] d = new int[10];
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            d[digit(n)]++;
        }
        f21.print1D(d);

        int[] dr = new int[10];
        int randomTimes = 1000;
        for (int i = 0; i < randomTimes; i++) {
            int randomNo = randomDist();
            dr[randomNo]++;
        }
        f21.print1D(dr);
    }
}
