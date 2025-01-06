public class app1510b {
    public static void main(String[] args) {
        int count = 0;
        while (!StdIn.isEmpty()) {
            int num = StdIn.readInt();
            if (num >= 0 && num <= 99) {
                StdOut.print(num + "\t");
                count++;
                if (count % 10 == 0) StdOut.println();
            }
        }
        StdOut.println();
    }
}
