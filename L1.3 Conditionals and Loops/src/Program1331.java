public class Program1331 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = i;
                int y = j;
                while (y != 0) {
                    int temp = x;
                    x = y;
                    y = temp % y;
                }
                if (x == 1) System.out.print("*  ");
                else System.out.print("   ");
            }
            System.out.println();
        }
    }
}
