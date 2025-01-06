public class TopSort {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int[] indegree = new int[n];
        @SuppressWarnings("unchecked")
        Queue<Integer>[] out = (Queue<Integer>[]) new Queue<>[n];
        for (int i = 0; i < n; i++) {
            out[i] = new Queue<Integer>();
        }

        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            out[i].enqueue(j);
            indegree[j]++;
        }

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.enqueue(i);
        }

        StdOut.print("Scheduled:          ");
        while (!queue.isEmpty()) {
            int i = queue.dequeue();
            StdOut.print(i + " ");
            while (!out[i].isEmpty()) {
                int j = out[i].dequeue();
                indegree[j]--;
                if (indegree[j] == 0) queue.enqueue(j);
            }
        }
        StdOut.println();

        StdOut.print("Could not schedule: ");
        for (int i = 0; i < n; i++)
            if (indegree[i] > 0) StdOut.print(i + " ");
        StdOut.println();
    }
}
