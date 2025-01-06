import java.util.NoSuchElementException;

public class GeneralizedQueue<Item> {
    private Node first;
    private Node last;
    private int n = 0;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    public Item remove(int i) {
        if (i <= 0 || i > n)
            throw new RuntimeException("Invalid value of i: " + i);
        if (isEmpty())
            throw new RuntimeException("Queue underflow.");

        Item item;
        if (i == 1) {
            item = first.item;
            first = first.next;
            if (first == null) last = null;
        } else {
            Node temp = first;
            for (int j = 1; j < i - 1; j++) {
                temp = temp.next;
                if (temp == null || temp.next == null)
                    throw new NoSuchElementException("ith node does not exist (i>size()).");
            }

            item = temp.next.item;
            temp.next = temp.next.next;
            if (temp.next == null) last = temp;
        }
        n--;
        return item;
    }

    public Item removeDefunct(int i) {
        if (i <= 0)
            throw new RuntimeException("Invalid value of i.");
        if (isEmpty())
            throw new RuntimeException("Queue underflow.");
        if (i == 1) {
            Item item = first.item;
            first = first.next;
            n--;
            return item;
        }
        Node temp = first;
        for (int j = 2; j < i; j++) {
            temp = temp.next;
            if (temp == null) throw new NoSuchElementException("ith node does not exist (i>size()).");
        }

        if (temp.next == null) throw new NoSuchElementException("ith node does not exist (i>size()).");
        Item item = temp.next.item;
        temp.next = temp.next.next;
        n--;
        return item;
    }

    public int size() {
        return n;
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
        GeneralizedQueue<Integer> queue = new GeneralizedQueue<>();
        for (int i = 1; i < 6; i++) {
            queue.add(i);
        }
        StdOut.println("queue: ");
        StdOut.println(queue);
        StdOut.println("queue.remove(1): " + queue.remove(1));
        StdOut.println("queue.remove(3): " + queue.remove(3));
        StdOut.println();
        StdOut.println("queue: ");
        StdOut.println(queue);
    }
}
