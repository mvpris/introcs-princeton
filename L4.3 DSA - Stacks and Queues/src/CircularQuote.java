public class CircularQuote {
    private Node first;
    private Node last;

    private class Node {
        private String word;
        private Node next;

        public Node(String word) {
            this.word = word;
            this.next = null;
        }
    }

    public CircularQuote() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(String word) {
        Node newNode = new Node(word);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            last.next = first;
        } else {
            last.next = newNode;
            last = newNode;
            last.next = first;
        }
    }

    public void add(int i, String word) {
        if (i < 1 || i > count() + 1) throw new RuntimeException("Index out of bounds.");
        Node newNode = new Node(word);
        if (i == 1) {
            if (isEmpty()) {
                first = newNode;
                last = newNode;
            } else {
                newNode.next = first;
                first = newNode;
            }
            last.next = first;
        } else {
            Node x = first;
            for (int k = 1; k < i - 1; k++) {
                x = x.next;
            }
            newNode.next = x.next;
            x.next = newNode;
            if (newNode.next == first) {
                last = newNode; // Update last if new node is inserted at the end
            }
        }
    }

    public String getWord(int i) {
        if (i < 1 || i > count()) {
            throw new RuntimeException("Index out of bounds.");
        }
        Node x = first;
        for (int k = 1; k < i; k++) {
            x = x.next;
        }
        return x.word;
    }

    public int count() {
        if (isEmpty()) return 0;
        int count = 0;
        Node x = first;
        do {
            count++;
            x = x.next;
        } while (x != first);
        return count;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        Node x = first;
        do {
            sb.append(x.word).append("\n");
            x = x.next;
        } while (x != first);
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularQuote quote = new CircularQuote();
        for (int i = 1; i < 5; i++) {
            quote.add("" + i);
        }
        StdOut.println("quote:\n" + quote);
        quote.add(1, "x");
        StdOut.println("quote:\n" + quote);
        StdOut.println("quote.getWord(5): " + quote.getWord(5));
        StdOut.println("quote.count(): " + quote.count());
    }
}
