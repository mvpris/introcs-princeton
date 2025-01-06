import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item> {
    private int n;
    private Item[] items;

    @SuppressWarnings("unchecked")
    public RandomQueue() {
        n = 0;
        items = (Item[]) new Object[1];
    }

    @SuppressWarnings("unchecked")
    public void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, items.length);
        items = temp;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == items.length;
    }

    public void enqueue(Item item) {
        if (isFull()) resize(2 * items.length);
        items[n++] = item;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new RuntimeException("Random queue underflow.");

        int r = StdRandom.uniformInt(n);
        Item item = items[r];
        items[r] = items[n - 1];
        items[n - 1] = null;
        n--;

        if (n > 0 && n == items.length / 4) resize(items.length / 2);
        return item;
    }

    public Item sample() {
        if (isEmpty())
            throw new RuntimeException("Random queue underflow.");
        return items[StdRandom.uniformInt(n)];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(items[i]).append("\n");
        }
        return sb.toString();
    }

    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private int i;
        private Item[] clone;

        public RandomQueueIterator() {
            clone = items.clone();
            i = n;
        }

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();

            int r = StdRandom.uniformInt(i);
            Item item = clone[r];
            clone[r] = clone[i - 1];
            clone[i - 1] = null;
            i--;
            return item;

        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        RandomQueue<Integer> queue = new RandomQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        StdOut.println("queue:");
        StdOut.println(queue);
        StdOut.println("sample(): " + queue.sample());
        StdOut.println("sample(): " + queue.sample());
        StdOut.println("dequeue(): " + queue.dequeue());
        StdOut.println("dequeue(): " + queue.dequeue());
        StdOut.println("queue.enqueue(7)");
        StdOut.println("queue.enqueue(9)");
        queue.enqueue(7);
        queue.enqueue(9);
        StdOut.println();
        StdOut.println("queue:");
        StdOut.println(queue);
        StdOut.println("dequeue():" + queue.dequeue());
        StdOut.println();
        StdOut.println("queue:");
        StdOut.println(queue);
        Iterator<Integer> I1 = queue.iterator();
        Iterator<Integer> I2 = queue.iterator();
        while (I1.hasNext()) StdOut.println("I1.next(): " + I1.next());
        StdOut.println();
        while (I2.hasNext()) StdOut.println("I2.next(): " + I2.next());
    }
}
