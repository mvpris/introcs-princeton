public class ReverseList<Item> {
    private Node first;
    private int n;

    private class Node {
        private Item item;
        private Node next;

    }

    public ReverseList() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Item item) {
        Node olfFirst = first;
        first = new Node();
        first.item = item;
        first.next = olfFirst;
        n++;
    }

    public Item remove() {
        if (isEmpty()) throw new RuntimeException("List underflow.");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public int size() {
        return n;
    }

    public Node peek() {
        return first;
    }

    public void reverseIterative() {
        if (first == null || first.next == null) return;
        Node previous = null;
        Node current = first;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;
    }

    public void reverseRecursive() {
        first = reverseRecursive(first);
    }

    private Node reverseRecursive(Node node) {
        if (node == null || node.next == null) return node;
        Node newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
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
        ReverseList<Integer> list = new ReverseList<>();
        for (int i = 1; i < 5; i++) {
            list.add(i);
        }
        StdOut.println("Original list:\n" + list);
        list.reverseIterative();
        StdOut.println("Reversed list iteratively:\n" + list);
        list.reverseRecursive();
        StdOut.println("Reversed list recursively:\n" + list);
    }
}
