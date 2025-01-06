public class ArrayQueueOfStrings {
    private final String[] items;
    private int n = 0;
    private int d = 0;

    public ArrayQueueOfStrings(int capacity) {
        items = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == items.length;
    }

    public void enqueue(String item) {
        if (isFull())
            throw new RuntimeException("Queue is full.");
        items[n++] = item;
    }

    public String dequeue() {
        return items[d++];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = d; i < n; i++) {
            s += items[i] + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        int capacity = Integer.parseInt(args[0]);
        ArrayQueueOfStrings queue = new ArrayQueueOfStrings(capacity);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
        StdOut.println(queue.toString());
    }
}
