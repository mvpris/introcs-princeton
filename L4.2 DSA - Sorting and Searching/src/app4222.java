public class app4222 {
    public static void main(String[] args) {
        // program uses counting sort algorithm which is a linear-time sorting algorithm for a fixed range of integers

        int[] a = new int[100];
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            if (x >= 0 && x < 100) a[x]++;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i]; j++) {
                StdOut.print(i + " ");
            }
        }
        StdOut.println();
    }
}
