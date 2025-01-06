public class Quote {
    private Node first;

    private class Node {
        private String word;
        private Node next;

        public Node(String word) {
            this.word = word;
            this.next = null;
        }
    }

    public Quote() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(String word) {
        Node newNode = new Node(word);
        if (isEmpty()) first = newNode;
        else {
            Node x = first;
            while (x.next != null) x = x.next;
            x.next = newNode;
        }
    }

    public void add(int i, String word) {
        if (i < 1 || i > count() + 1) throw new RuntimeException("Index out of bounds.");
        Node newNode = new Node(word);
        if (i == 1) {
            newNode.next = first;
            first = newNode;
        } else {
            Node x = first;
            for (int k = 1; k < i - 1; k++) {
                x = x.next;
            }
            newNode.next = x.next;
            x.next = newNode;
        }
    }

    public String getWord(int i) {
        if (count() < i || count() <= 0) throw new RuntimeException("Index out of bounds.");
        Node x = first;
        for (int k = 1; k < i; k++) {
            x = x.next;
        }
        return x.word;
    }

    public int count() {
        int count = 0;
        for (Node x = first; x != null; x = x.next) {
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node x = first; x != null; x = x.next) {
            sb.append(x.word).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Quote quote = new Quote();
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
