import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class SETbst<Key extends Comparable<Key>> implements Iterable<Key> {
    private TreeSet<Key> set;

    public SETbst() {
        set = new TreeSet<>();
    }

    public SETbst(SETbst<Key> x) {
        set = new TreeSet<>(x.set);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return set.size();
    }

    public void add(Key key) {
        if (key == null) throw new IllegalArgumentException("called add() with null argument");
        set.add(key);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("called contains() with null argument");
        return set.contains(key);
    }

    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("called remove() with null argument");
        set.remove(key);
    }

    public Iterator<Key> iterator() {
        return set.iterator();
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty set");
        return set.first();
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty set");
        return set.last();
    }

    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("called ceiling() with null argument");
        Key k = set.ceiling(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("called floor() with null argument");
        Key k = set.floor(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    public SETbst<Key> union(SETbst<Key> that) {
        if (that == null) throw new IllegalArgumentException("called union() with null argument");
        SETbst<Key> c = new SETbst<>();
        for (Key key : this) c.add(key);
        for (Key key : that) c.add(key);
        return c;
    }

    public SETbst<Key> intersects(SETbst<Key> that) {
        if (that == null) throw new IllegalArgumentException("called intersects() with null argument");
        SETbst<Key> c = new SETbst<>();
        if (this.size() < that.size()) {
            for (Key key : this) {
                if (that.contains(key)) c.add(key);
            }
        } else {
            for (Key key : that) {
                if (this.contains(key)) c.add(key);
            }
        }
        return c;
    }

    @Override
    public String toString() {
        String s = set.toString();
        return "{ " + s.substring(1, s.length() - 1) + " }";
    }

    public static void main(String[] args) {

    }
}
