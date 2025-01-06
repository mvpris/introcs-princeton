public class ResizingArrayQueueOfStrings {
    private String[] items = new String[1];
    private int n = 0;
    private int d = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int capacity) {
        String[] temp = new String[capacity];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public void enqueue(String item) {
        if (n == items.length) resize(2 * items.length);
        items[n++] = item;
    }

    public String dequeue() {
        String item = items[d];
        items[d++] = null;
        if (n > 0 && n == items.length / 4) resize(items.length / 2);
        return item;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = d; i < n; i++) {
            s += items[i] + " ";
        }
        return s;
    }

    public void toString2() {
        for (int i = d; i < n; i++) {
            StdOut.print(items[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
        StdOut.println(queue.toString());
        queue.toString2();
    }
}
