public class BT {
    private Node root;

    private static class Node {
        private double key;
        private Node left, right;
        private int size;

        public Node(double key, int size) {
            this.key = key;
            this.size = size;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public double total() {
        return total(root);
    }

    private double total(Node x) {
        if (x == null) return 0;
        return x.key + total(x.left) + total(x.right);
    }

    public int leaves() {
        return leaves(root);
    }

    private int leaves(Node x) {
        if (x == null) return 0;
        if (x.left == null && x.right == null) return 1;
        return leaves(x.left) + leaves(x.right);
    }

    // put() method specific to a BST tree
    public void put(double key) {
        root = put(root, key);
    }

    private Node put(Node x, double key) {
        if (x == null) return new Node(key, 1);
        if (key < x.key) x.left = put(x.left, key);
        else if (key > x.key) x.right = put(x.right, key);
        else x.key = key;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    // put() method specific to a heap ordered tree
    /*
    public void put(double key) {
        root = put(root, key);
    }

    private Node put(Node x, double key) {
        if (x == null) return new Node(key, 1);

        // If the key is larger, bubble up
        if (key > x.key) {
            Node newNode = new Node(key, 1);
            newNode.left = x;
            return newNode;
        } else {
            // Insert in the left or right subtree
            if (x.left == null) x.left = put(x.left, key);
            else if (x.right == null) x.right = put(x.right, key);
            else x.left = put(x.left, key);  // Arbitrarily choose left if both are non-null
        }

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
     */

    public Iterable<Double> keys() {
        Queue<Double> queue = new Queue<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node x, Queue<Double> queue) {
        if (x == null) return;
        inorder(x.left, queue);
        queue.enqueue(x.key);
        inorder(x.right, queue);
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public boolean heapOrdered() {
        return heapOrdered(root);
    }

    private boolean heapOrdered(Node x) {
        if (x == null) return true;
        if (x.left != null && x.key < x.left.key) return false;
        if (x.right != null && x.key < x.right.key) return false;
        return heapOrdered(x.left) && heapOrdered(x.right);
    }

    public boolean balanced() {
        return balanced(root) != -1;
    }

    private int balanced(Node x) {
        if (x == null) return 0;

        int leftHeight = balanced(x.left);
        if (leftHeight == -1) return -1;

        int rightHeight = balanced(x.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isomorphic(Node x, Node y) {
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        return isomorphic(x.left, y.left) && isomorphic(x.right, y.right);
    }

    public static boolean eq(Node x, Node y) {
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        if (x.key != y.key) return false;
        return eq(x.left, y.left) && eq(x.right, y.right);
    }

    public Iterable<Double> levelOrder() {
        Queue<Double> keys = new Queue<>();
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

    // Always returns 0 for any binary tree
    public int mystery(Node x) {
        if (x == null) return 0;
        return mystery(x.left) + mystery(x.right);
    }

    public static void main(String[] args) {
        BT bt = new BT();
        bt.put(2);
        bt.put(1);
        bt.put(3);
        bt.put(4);
        bt.put(71);
        StdOut.println(bt.total());
//        for (Double d : bt.keys()) StdOut.print(d + " ");
//        StdOut.println();
    }
}
