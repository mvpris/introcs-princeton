public class app435 {
    public static void main(String[] args) {
        Queue<Double> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            double n = StdIn.readDouble();
            queue.enqueue(n);   // Autoboxing (double->Double)
        }
        for (Double n : queue) StdOut.print(n + " ");
        StdOut.println();
    }
}
