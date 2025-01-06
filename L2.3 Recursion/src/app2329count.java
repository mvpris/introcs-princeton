public class app2329count {
    public static void main(String[] args) {
        int count = 0;
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            count++;
        }
        StdOut.println("count = " + count);
    }
}
