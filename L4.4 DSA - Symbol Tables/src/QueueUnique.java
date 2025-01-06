import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueUnique<Item> {
    private final Queue<Item> queue;

    public QueueUnique() {
        queue = new LinkedList<>();
    }

    public QueueUnique(QueueUnique<Item> other) {
        queue = new LinkedList<>(other.queue);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void add(Item item) {
        if (item == null) throw new IllegalArgumentException("called add() with null argument");
        if (!queue.contains(item)) queue.add(item);
    }

    public Item remove() {
        if (queue.isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = queue.peek();
        queue.remove();
        return item;
    }

    public int size() {
        return queue.size();
    }

    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        QueueUnique<String> queueUnique = new QueueUnique<>();
        queueUnique.add("One");
        queueUnique.add("Two");
        queueUnique.add("Three");
        StdOut.println(queueUnique.remove());
        StdOut.println(queueUnique);
    }
}
