public class SEThashSet<Key> {
    private static final int INIT_CAPACITY = 4;
    private int m;
    private int n;
    private Node[] lists;

    private static class Node {
        private Object key;
        private Node next;

        public Node(Object key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public SEThashSet() {
        this(INIT_CAPACITY);
    }

    public SEThashSet(int m) {
        this.m = m;
        lists = new Node[m];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        SEThashSet<Key> temp = new SEThashSet<>(capacity);
        for (int i = 0; i < m; i++) {
            for (Node x = lists[i]; x != null; x = x.next) {
                temp.add((Key) x.key);
            }
        }
        this.m = temp.m;
        this.n = temp.n;
        this.lists = temp.lists;
    }

    public void add(Key key) {
        if (key == null) throw new IllegalArgumentException("called add() with key argument");
        if (n * 8 >= m) resize(2 * m);

        int i = hash(key);
        for (Node x = lists[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return;
        }
        n++;
        lists[i] = new Node(key, lists[i]);
    }

    public int hash(Key key) {
        return Math.abs(key.hashCode() % m);
    }

    @SuppressWarnings("unchecked")
    public Key get(Key key) {
        if (key == null) throw new IllegalArgumentException("called get() with null argument");
        int i = hash(key);
        for (Node x = lists[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Key) x.key;
        }
        return null;
    }

    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("called remove() with null argument");
        int i = hash(key);
        lists[i] = remove(lists[i], key);
        if (m > INIT_CAPACITY && n <= 2 * m) resize(m / 2);
    }

    private Node remove(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = remove(x.next, key);
        return x;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("called contains() with null argument");
        return get(key) != null;
    }

    public int size() {
        return n;
    }

    @SuppressWarnings("unchecked")
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < m; i++) {
            for (Node x = lists[i]; x != null; x = x.next) {
                queue.enqueue((Key) x.key);
            }
        }
        return queue;
    }

    public static void main(String[] args) {

    }
}
