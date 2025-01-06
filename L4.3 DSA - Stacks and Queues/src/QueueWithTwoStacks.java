public class QueueWithTwoStacks<Item> {
    private Stack<Item> s1;
    private Stack<Item> s2;

    public QueueWithTwoStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public void enqueue(Item item) {
        s1.push(item);
    }

    public Item dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    @Override
    public String toString() {
        Stack<Item> tempStack1 = new Stack<>();
        Stack<Item> tempStack2 = new Stack<>();

        for (Item item : s1) {
            tempStack1.push(item);
        }

        for (Item item : s2) {
            tempStack2.push(item);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");

        while (!tempStack2.isEmpty()) {
            sb.append(tempStack2.pop()).append(" ");
        }

        Stack<Item> reverseStack = new Stack<>();
        while (!tempStack1.isEmpty()) {
            reverseStack.push(tempStack1.pop());
        }

        while (!reverseStack.isEmpty()) {
            sb.append(reverseStack.pop()).append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> q = new QueueWithTwoStacks<>();
        for (int i = 1; i < 5; i++) {
            q.enqueue(i);
        }
        StdOut.println(q);
        StdOut.println("queue.dequeue(): " + q.dequeue());
        StdOut.println("queue.dequeue(): " + q.dequeue());
        StdOut.println(q);
        q.enqueue(9);
        StdOut.println("queue.enqueue(9)");
        StdOut.println("queue.dequeue(): " + q.dequeue());
        StdOut.println(q);
        q.enqueue(29);
        StdOut.println("queue.enqueue(29)");
        StdOut.println("queue.dequeue(): " + q.dequeue());
        StdOut.println(q);
        StdOut.println("queue.dequeue(): " + q.dequeue());
        q.enqueue(6);
        StdOut.println("queue.enqueue(6)");
        StdOut.println(q);
        StdOut.println("queue.dequeue(): " + q.dequeue());
        StdOut.println(q);
    }
}
