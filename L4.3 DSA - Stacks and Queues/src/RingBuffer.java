public class RingBuffer<Item> {
    private final Item[] items;
    private int head;
    private int tail;
    private int n;

    @SuppressWarnings("unchecked")
    public RingBuffer(int capacity) {
        items = (Item[]) new Object[capacity];
        head = 0;
        tail = 0;
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
            head = (head + 1) % items.length; // Overwrite the oldest item
        } else {
            n++;
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
    }

    public Item remove() {
        if (isEmpty()) {
            throw new RuntimeException("Buffer underflow.");
        }
        Item item = items[head];
        items[head] = null;
        head = (head + 1) % items.length;
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
        RingBuffer<Integer> buffer = new RingBuffer<>(5);
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
    }
}
