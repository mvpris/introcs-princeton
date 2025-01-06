import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    public Deque() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (first == null) first = last;
        else oldLast.next = last;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        if (oldFirst != null) oldFirst.prev = first;
        if (last == null) last = first;
    }

    public Item pop() {
        if (first == null) throw new RuntimeException("Deque underflow.");
        Item item = first.item;
        first = first.next;
        if (first != null) first.prev = null;
        else last = null;
        return item;
    }

    public Item dequeue() {
        if (first == null) throw new RuntimeException("Deque underflow.");
        Item item = last.item;
        last = last.prev;
        if (last != null) last.next = null;
        else first = null;
        return item;
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
            sb.append(x.item).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.push(1);
        deque.push(2);
        deque.enqueue(3);
        deque.enqueue(4);
        StdOut.println("deque:");
        StdOut.println(deque);
        StdOut.println("deque.pop(): " + deque.pop()); // 2
        StdOut.println("deque.dequeue(): " + deque.dequeue()); // 4
        StdOut.println();
        StdOut.println("deque:");
        StdOut.print(deque);
    }
}
