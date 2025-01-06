public class app157 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] a = new int[n];
        
//        Read array
        for (int i = 0; i < n - 1; i++) {
            int num = StdIn.readInt();
            if (num < 1 || num > n) {
                StdOut.println("Invalid input. Please enter a number between 1 and n-1.");
                i--;
            } else a[i] = num;
        }

//        Sort array with 0 in place of missing number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] == i + 1) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

//        Print array
        for (int i = 0; i < n; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();

//        Print missing number
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                StdOut.println("Missing number: " + (i + 1));
            }
        }
    }
}
