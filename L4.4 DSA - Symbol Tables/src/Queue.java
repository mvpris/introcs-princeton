import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        private Item item;
        private Node next;
    }

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    public Queue(Queue<Item> other) {
        for (Item item : other) this.enqueue(item);
        this.n = other.n;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow.");
        return first.item;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node x = first; x != null; x = x.next) {
            sb.append(x.item).append(" ");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
        StdOut.println(queue.toString());
        for (String s : queue) StdOut.print(s + " ");
        StdOut.println();
        StdOut.println("queue.peek()=" + queue.peek());
        StdOut.println("queue.size()=" + queue.size());

        Queue<String> q1 = new Queue<>();
        q1.enqueue("a");
        q1.enqueue("b");
        q1.enqueue("c");

        Queue<String> q2 = new Queue<>(q1);
        q2.enqueue("d");

        StdOut.println();
        StdOut.println("Original Queue:\n" + q1);
        StdOut.println("Copied Queue:\n" + q2);
    }
}
