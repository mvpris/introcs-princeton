public class Program1415 {
    public static void main(String[] args) {
        int[][] a =
                {
                        {91, 81, 92, 0},
                        {98, 57, 79, 0},
                        {92, 77, 72, 0},
                        {94, 62, 82, 0},

                };
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a[0].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) System.out.print(" " + a[i][j] + " ");
                else System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
