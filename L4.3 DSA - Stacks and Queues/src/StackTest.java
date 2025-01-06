import java.util.Iterator;

public class StackTest<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (first == null) throw new RuntimeException("Stack underflow.");
        Item item = first.item;
        first = first.next;
        n--;
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
        StringBuilder s = new StringBuilder();
        for (Node x = first; x != null; x = x.next) {
            s.append(x.item).append(" ");
        }
        return s.toString();
    }

    public Item peek() {
        if (first == null) throw new RuntimeException("Stack underflow.");
        return first.item;
    }

    public int size() {
        return n;
    }

    public boolean find(Item key) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(key)) return true;
            current = current.next;
        }
        return false;
    }

    public Item findItem(Item key) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(key)) return current.item;
            current = current.next;
        }
        return null;
    }

    public Node findNode(Item key) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(key)) return current;
            current = current.next;
        }
        return null;
    }

    public void delete(int k) {
        if (k <= 0) throw new RuntimeException("Invalid value of k.");
        if (first == null) return;
        if (k == 1) {
            first = first.next;
            return;
        }
        Node current = first;
        for (int i = 2; i < k; i++) {
            current = current.next;
            if (current == null) return;
        }
        if (current.next == null) return;
        current.next = current.next.next;
    }

    public void removeAfter(Node node) {
        if (node == null || node.next == null) return;
        node.next = node.next.next;
    }

    public Stack<Item> copy() {
        Stack<Item> intermediate = new Stack<>();
        Stack<Item> result = new Stack<>();
        if (first == null) return result;

        Node current = first;

        while (current != null) {
            intermediate.push(current.item);
            current = current.next;
        }
        while (!intermediate.isEmpty()) {
            result.push(intermediate.pop());
        }
        return result;
    }

    public void remove(Item key) {
        Node current = first;
        while (current != null && current.next != null) {
            if (current.item.equals(key)) current.next = current.next.next;
            else current = current.next;
        }
        if (first != null && first.item.equals(key)) first = first.next;
    }

    public int max() {
        if (first == null) return 0;
        int maxValue = Integer.MIN_VALUE;
        Node current = first;
        while (current != null) {
            int value = Integer.parseInt(current.item.toString());
            if (value > maxValue) maxValue = value;
            current = current.next;
        }
        return maxValue;
    }

    public Node reverse() {
        Node previous = null;
        Node current = first;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;
        return first;
    }

    public void printReverseQuadratic(Node node) {
        if (node == null) return;
        printReverseQuadratic(node.next);
        StdOut.print(node.item + " ");
    }

    public void printReverseLinear(Node node) {
        Stack<Item> stack = new Stack<>();
        while (node != null) {
            stack.push(node.item);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            StdOut.print(stack.pop() + " ");
        }
    }

    public void printReverseDivideAndConquer(Node node) {
        if (node == null) return;
        printReverseHelper(node, length(node));
    }

    private void printReverseHelper(Node node, int length) {
        if (length == 0) return;
        if (length == 1) {
            System.out.print(node.item + " ");
            return;
        }
        int mid = length / 2;
        Node midNode = node;
        for (int i = 0; i < mid; i++) {
            midNode = midNode.next;
        }
        printReverseHelper(midNode, length - mid);
        printReverseHelper(node, mid);
    }

    private int length(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public void shuffle() {
        shuffle(first, n);
    }

    private void shuffle(Node node, int size) {
        if (size <= 1) return;
        int randomIndex = StdRandom.uniformInt(size);
        Node randomNode = getNodeAt(node, randomIndex);
        swap(node, randomNode);
        shuffle(node.next, size - 1);
    }

    public Node getNodeAt(Node node, int index) {
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void swap(Node a, Node b) {
        Item temp = a.item;
        a.item = b.item;
        b.item = temp;
    }

    public static void main(String[] args) {
        StackTest<Integer> stack = new StackTest<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.shuffle();

        for (int item : stack) {
            System.out.println(item);
        }
    }
}
