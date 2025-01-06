public class RingBufferDefunct<Item> {
    private final Item[] items;
    private int n;

    @SuppressWarnings("unchecked")
    public RingBufferDefunct(int capacity) {
        items = (Item[]) new Object[capacity];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == items.length;
    }

    public void add(Item item) {
        if (isFull()) {
            for (int i = 0; i < n - 1; i++) {
                items[i] = items[i + 1];
            }
            items[n - 1] = item;
        } else items[n++] = item;
    }

    public Item remove() {
        if (isEmpty())
            throw new RuntimeException("Buffer underflow.");
        Item item = items[0];
        for (int i = 0; i < n - 1; i++) {
            items[i] = items[i + 1];
        }
        items[n - 1] = null;
        n--;
        return item;
    }

    public int size() {
        return n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            sb.append(items[i]).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RingBufferDefunct<Integer> buffer = new RingBufferDefunct<>(5);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        StdOut.println(buffer);
        StdOut.println(buffer.remove()); // Outputs 1
        StdOut.println();
        StdOut.println(buffer);
        buffer.add(4);
        buffer.add(5);
        buffer.add(6);
        StdOut.println(buffer);
        StdOut.println(buffer.remove()); // Outputs 2
        StdOut.println();
        StdOut.println(buffer);
        buffer.add(7);
        buffer.add(8);
        StdOut.println();
        StdOut.println(buffer);
    }
}
