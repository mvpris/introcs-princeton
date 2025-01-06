import java.util.NoSuchElementException;

public class SETbstown<Key extends Comparable<Key>> {
    private Node root;

    private class Node {
        private Key key;
        private Node left, right;
        private int size;

        public Node(Key key, int size) {
            this.key = key;
            this.size = size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return root.size;
    }

    public void add(Key key) {
        if (key == null) throw new IllegalArgumentException("called add() with null argument");
        root = add(root, key);
    }

    private Node add(Node x, Key key) {
        if (x == null) return new Node(key, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = add(x.left, key);
        else if (cmp > 0) x.right = add(x.right, key);
        else x.key = key;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("called contains() with null argument");
        return get(key) != null;
    }

    public Key get(Key key) {
        if (key == null) throw new IllegalArgumentException("called get() with null argument");
        return get(root, key);
    }

    private Key get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.key;
    }

    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("called remove() with null argument");
        root = remove(root, key);
    }

    private Node remove(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = remove(x.left, key);
        else if (cmp > 0) x.right = remove(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = removeMin(t.right);
            x.left = t.left;

        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Node min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root);
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    public void removeMin() {
        if (isEmpty()) throw new NoSuchElementException("called removeMin() with empty symbol table");
        root = removeMin(root);
    }

    private Node removeMin(Node x) {
        if (x.left == null) return x.right;
        x.left = removeMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node x, Queue<Key> queue) {
        if (x == null) return;
        inorder(x.left, queue);
        queue.enqueue(x.key);
        inorder(x.right, queue);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toStringHelper(root, sb));
        return sb.toString();
    }

    private String toStringHelper(Node x, StringBuilder sb) {
        if (x == null) return "";
        toStringHelper(x.left, sb);
        sb.append(x.key).append(" ");
        toStringHelper(x.right, sb);
        return "";
    }

    public static void main(String[] args) {
        SETbstown<String> SETbstown = new SETbstown<>();
        String[] words = {"the", "it", "was", "best", "of", "times", "worst"};

        for (String word : words) {
            SETbstown.add(word);
        }

        StdOut.println(SETbstown.toString());
    }
}
