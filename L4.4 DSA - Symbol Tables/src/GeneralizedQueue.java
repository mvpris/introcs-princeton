public class GeneralizedQueue<Item> {
    private final BST<Integer, Item> bst;
    Integer k = 0;

    public GeneralizedQueue() {
        bst = new BST<>();
    }

    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public void add(Item item) {
        bst.put(k, item);
        k++;
    }

    public Item remove(int i) {
        Item item = bst.get(bst.select(i));
        bst.delete(i);
        return item;
    }

    public int size() {
        return bst.size();
    }

    public String toString() {
        return bst.toString();
    }

    public static void main(String[] args) {
        GeneralizedQueue<String> generalizedQueue = new GeneralizedQueue<>();
        generalizedQueue.add("One");
        generalizedQueue.add("Two");
        generalizedQueue.add("Three");
        StdOut.println(generalizedQueue.remove(1));
        generalizedQueue.add("Four");
        StdOut.println("generalizedQueue.size() = " + generalizedQueue.size());
        StdOut.println(generalizedQueue);
    }
}
