public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int n = 0;

    @SuppressWarnings("unchecked")
    public BinarySearchST() {
        keys = (Key[]) new Comparable[1];
        values = (Value[]) new Object[1];
    }

    @SuppressWarnings("unchecked")
    public void resize(int capacity) {
        Key[] keysTemp = (Key[]) new Comparable[capacity];
        Value[] valuesTemp = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            keysTemp[i] = keys[i];
            valuesTemp[i] = values[i];
        }
        keys = keysTemp;
        values = valuesTemp;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void put(Key key, Value value) {
        if (n >= values.length) resize(2 * n);

        // update value if key-value pair is already in ST
        if (contains(key)) {
            int i = bsearch(key);
            values[i] = value;
            return;
        }

        // shift key-value pairs one position to right, and add new key-value pair
        int i = n;
        while (i > 0 && key.compareTo(keys[i - 1]) < 0) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
            i--;
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    public Value get(Key key) {
        int i = bsearch(key);
        if (i == -1) return null;
        return values[i];
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean contains2(Key key) {
        int i = bsearch(key);
        return (i >= 0);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }

    private int bsearch(Key key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchST<String, String> st = new BinarySearchST<>();

        // insert some key-value pairs
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.cs.princeton.edu", "128.112.136.35");
        st.put("www.princeton.edu", "128.112.130.211");
        st.put("www.math.princeton.edu", "128.112.18.11");
        st.put("www.yale.edu", "130.132.51.8");
        st.put("www.amazon.com", "207.171.163.90");
        st.put("www.simpsons.com", "209.123.16.34");
        st.put("www.stanford.edu", "171.67.16.120");
        st.put("www.google.com", "64.233.161.99");
        st.put("www.ibm.com", "129.42.16.99");
        st.put("www.apple.com", "17.254.0.91");
        st.put("www.slashdot.com", "66.35.250.150");
        st.put("www.whitehouse.gov", "204.153.49.136");
        st.put("www.espn.com", "199.181.132.250");
        st.put("www.snopes.com", "66.165.133.65");
        st.put("www.movies.com", "199.181.132.250");
        st.put("www.cnn.com", "64.236.16.20");
        st.put("www.iitb.ac.in", "202.68.145.210");

        // search for IP addresses given URL
        StdOut.println("size = " + st.size());
        StdOut.println(st.get("www.cs.princeton.edu"));
        StdOut.println(st.get("www.amazon.com"));
        StdOut.println(st.get("www.amazon.edu"));
        StdOut.println(st.get("www.yale.edu"));
        StdOut.println();
    }
}
