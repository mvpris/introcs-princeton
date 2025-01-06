public class Program1413 {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[][] num = new int[m][n];
        int[][] a = new int[num.length][];
        for (int i = 0; i < num.length; i++) {
            a[i] = new int[num[i].length];

            for (int j = 0; j < num[i].length; j++) {
                a[i][j] = num[i][j];
            }
        }
    }
}
