public class Program1414 {
    public static void main(String[] args) {
        int[][] a =
                {
                        {99, 85, 98, 0},
                        {98, 57, 79, 0},
                        {92, 77, 74, 0},
                        {94, 62, 81, 0},
                        {99, 94, 92, 0},
                        {80, 76, 67, 0},
                        {76, 58, 90, 0},
                        {92, 66, 91, 0},
                        {97, 70, 66, 0},
                        {89, 89, 81, 0},
                        {0, 0, 0, 0}
                };

//        Create transpose array
        int[][] b = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[j][i] = a[i][j];
            }
        }

//        Print transpose array
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
