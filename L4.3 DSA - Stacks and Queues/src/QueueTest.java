import java.util.Iterator;

public class QueueTest<Item> implements Iterable<Item> {
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    @Override
    public String toString() {
        String s = "";
        for (Node x = first; x != null; x = x.next) {
            s += x.item + " ";
        }
        return s;
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

    public static void main(String[] args) {
        QueueTest<String> queue = new QueueTest<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
        StdOut.println(queue.toString());
        for (String s : queue) StdOut.print(s + " ");
        StdOut.println();
    }
}
