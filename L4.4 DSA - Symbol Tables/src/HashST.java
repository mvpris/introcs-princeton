public class HashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int m;
    private int n;
    private Node[] lists;

    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public HashST() {
        this(INIT_CAPACITY);
    }

    public HashST(int m) {
        this.m = m;
        lists = new Node[m];
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        HashST<Key, Value> temp = new HashST<>(capacity);
        for (int i = 0; i < m; i++) {
            for (Node x = lists[i]; x != null; x = x.next) {
                temp.put((Key) x.key, (Value) x.val);
            }
        }
        this.m = temp.m;
        this.n = temp.n;
        this.lists = temp.lists;
    }

    public int hash(Key key) {
        return Math.abs(key.hashCode() % m);
    }

    @SuppressWarnings("unchecked")
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        for (Node x = lists[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument to put() is null");
        if (val == null) {
            remove(key);
            return;
        }

        if (n >= 8 * m) resize(2 * m);

        int i = hash(key);
        for (Node x = lists[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        n++;
        lists[i] = new Node(key, val, lists[i]);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public int size() {
        return n;
    }

    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to remove() is null");
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
