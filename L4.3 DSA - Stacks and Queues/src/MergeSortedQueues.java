public class MergeSortedQueues {
    public static Queue<String> mergeQueues(Queue<String> q1, Queue<String> q2) {
        Queue<String> mergedQueue = new Queue<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek().compareTo(q2.peek()) <= 0) mergedQueue.enqueue(q1.dequeue());
            else mergedQueue.enqueue(q2.dequeue());
        }

        while (!q1.isEmpty()) mergedQueue.enqueue(q1.dequeue());
        while (!q2.isEmpty()) mergedQueue.enqueue(q2.dequeue());

        return mergedQueue;
    }

    public static void main(String[] args) {
        Queue<String> q1 = new Queue<>();
        Queue<String> q2 = new Queue<>();

        q1.enqueue("apple");
        q1.enqueue("banana");
        q1.enqueue("cherry");

        q2.enqueue("apricot");
        q2.enqueue("blueberry");
        q2.enqueue("citrus");

        Queue<String> mergedQueue = mergeQueues(q1, q2);

        StdOut.println("Merged Queue: ");
        StdOut.print(mergedQueue);
    }
}
