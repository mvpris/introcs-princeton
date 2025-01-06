import java.util.NoSuchElementException;

public class GeneralizedQueueResizing<Item> {
    private Item[] items;
    private int n;

    @SuppressWarnings("unchecked")
    public GeneralizedQueueResizing() {
        items = (Item[]) new Object[1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == items.length;
    }

    @SuppressWarnings("unchecked")
    public void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public void add(Item item) {
        if (isFull()) resize(2 * items.length);
        items[n++] = item;
    }

    public Item remove(int i) {
        if (i < 1 || i > n)
            throw new NoSuchElementException("ith item does not exist.");
        if (isEmpty())
            throw new RuntimeException("Queue underflow.");
        i = i - 1;
        Item item = items[i];
        for (int j = i; j < n - 1; j++) {
            items[j] = items[j + 1];
        }
        items[n - 1] = null;
        n--;
        if (n > 0 && n == items.length / 4) resize(items.length / 2);
        return item;
    }

    public int size() {
        return n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(items[i]).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GeneralizedQueueResizing<Integer> queue = new GeneralizedQueueResizing<>();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        StdOut.println(queue);
        StdOut.println("queue.remove(2): " + queue.remove(2));
        StdOut.println("queue.remove(2): " + queue.remove(2));
        StdOut.println(queue);
    }
}
