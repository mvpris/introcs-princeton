public class Josephus {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }

        StdOut.println("initial queue:");
        StdOut.println(queue);

        while (!queue.isEmpty()) {
            for (int i = 0; i < m - 1; i++)
                queue.enqueue(queue.dequeue());
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
    }
}
