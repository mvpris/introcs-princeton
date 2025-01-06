public class app1511 {
    public static void main(String[] args) {
        int count = 0;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            count++;
        }
        StdOut.println("No of words= " + count);
    }
}
