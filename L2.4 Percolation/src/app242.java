public class app242 {
    public static void print(boolean[][] isOpen) {
        int n = isOpen.length;
        boolean[][] isFull = Percolation.flow(isOpen);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isOpen[i][j]) {
                    System.out.print("1 "); // Blocked site
                } else if (isFull[i][j]) {
                    System.out.print("* "); // Full site
                } else {
                    System.out.print("0 "); // Open site
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] isOpen = StdArrayIO.readBoolean2D();
        print(isOpen);
    }
}
