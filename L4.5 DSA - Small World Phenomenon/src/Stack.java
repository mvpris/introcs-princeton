import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    private class Node {
        private Item item;
        private Node next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public Stack(Stack<Item> other) {
        Stack<Item> temp = new Stack<>();
        for (Item item : other) temp.push(item);
        for (Item item : temp) this.push(item);
        this.n = other.n;
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
        StringBuilder sb = new StringBuilder();
        for (Node x = first; x != null; x = x.next) {
            sb.append(x.item).append(" ");
        }
        return sb.toString();
    }

    public Item peek() { // Returns the most recently inserted item on the stack (without removing it) (app439)
        if (first == null) throw new NoSuchElementException("Stack underflow.");
        return first.item;
    }

    public int size() { // Returns the number of items in the collection (app4311)
        return n;
    }

    public boolean find(Item key) { // Returns boolean if any node in the list has key as its item field (app4324)
        Node current = first;
        while (current != null) {
            if (current.item.equals(key)) return true;
            current = current.next;
        }
        return false;
    }

    public Item findItem(Item key) { // Returns the item if any node in the list has key as its item field
        Node current = first;
        while (current != null) {
            if (current.item.equals(key)) return current.item;
            current = current.next;
        }
        return null;
    }

    public Node findNode(Node key) { // Returns the node if a node exists in the list with the same reference
        Node current = first;
        while (current != null) {
            if (current.equals(key)) return current;
            current = current.next;
        }
        return null;
    }

    public Node findNodeWithItem(Item key) { // Returns the node if any node in the list has key as its item field
        Node current = first;
        while (current != null) {
            if (current.equals(key)) return current;
            current = current.next;
        }
        return null;
    }

    public void delete(int k) { // Deletes the kth node in the linked list, if it exists. (app4325)
        if (k <= 0) throw new RuntimeException("Invalid value of k.");
        if (first == null) return;
        if (k == 1) {
            first = first.next;
            n--;
            return;
        }

        Node temp = first;
        for (int i = 2; i < k; i++) {
            temp = temp.next;
            if (temp == null) return;
        }

        if (temp.next == null) return;

        temp.next = temp.next.next;
        n--;
    }

    public void removeAfter(Node node) {
        if (node == null || node.next == null) return;
        node.next = node.next.next;
        n--;
    }

    public Stack<Item> copy() { // Creates a new linked list with the same sequence of items,
        // without destroying the original linked list. (app4329)
        // Using an intermediate stack copying (uses additional space for 2nd stack and additional startTime for 2nd while loop)

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


    public Stack<Item> copyDC() {// Creates a new linked list with the same sequence of items,
        // without destroying the original linked list. (app4329)
        // Direct copying, does not use additional space & startTime

        Stack<Item> result = new Stack<>();
        if (first == null) return result; // Handle empty list case

        Node current = first;
        Node newFirst = new Node();
        newFirst.item = current.item;
        result.first = newFirst;
        Node newCurrent = newFirst;

        current = current.next;
        while (current != null) {
            Node newNode = new Node();
            newNode.item = current.item;
            newCurrent.next = newNode;
            newCurrent = newNode;
            current = current.next;
        }

        return result;
    }


    public void remove(Item key) { // Removes every node in the list whose item field is equal to key. (app4330)
        Node current = first;
        while (current != null && current.next != null) {
            if (current.next.item.equals(key)) {
                current.next = current.next.next;
                n--;
            } else current = current.next;
        }
        // Special case : if the first node itself needs to be removed
        if (first != null && first.item.equals(key)) {
            first = first.next;
            n--;
        }
    }

    public int max() { // Returns the value of the maximum item in the list. (app4331)
        if (first == null) return 0;
        int maxItem = Integer.MIN_VALUE;
        Node current = first;
        while (current != null) {
            int item = Integer.parseInt(current.item.toString());
            if (item > maxItem) maxItem = item;
            current = current.next;
        }
        return maxItem;
    }

    public int maxRec() { // Returns the value of the maximum item in the list. (app4332)
        return maxRec(first);
    }

    private int maxRec(Node node) { // Returns the value of the maximum item in the list. (app4332)
        if (node == null) return 0;
        int maxInRest = maxRec(node.next);
        int currentItem = Integer.parseInt(node.item.toString());
        return Math.max(currentItem, maxInRest);
    }

    public void reverse() {
        Node previous = null;
        Node current = first;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;
    }

    public void reverseRec() {
        first = reverseRec(first);
    }

    private Node reverseRec(Node node) {
        if (node == null || node.next == null) return node;
        Node newHead = reverseRec(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
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
        while (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
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
        Stack<String> stack = new Stack<>();
        StdOut.println();
        StdOut.println("Items popped from the stack:");
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else StdOut.print(stack.pop() + " ");
        }
        StdOut.println();
        StdOut.println();
        StdOut.println("stack:\n" + stack);

        Stack<String> stack2 = new Stack<>();
        stack2.push("first");
        stack2.push("second");
        stack2.push("third");
        stack2.push("forth");
        stack2.push("fifth");

        StdOut.println("stack2.peek()=" + stack2.peek());
        StdOut.println();
        StdOut.println("stack2.size()=" + stack2.size());
        StdOut.println();
        StdOut.println("stack2.find(\"second\")=" + stack2.find("second"));
        StdOut.println();

        stack2.delete(3);
        StdOut.println("stack2 after stack2.delete(3):");
        StdOut.println(stack2);

        stack2.removeAfter(stack2.findNodeWithItem("second"));

        StdOut.println("stack2 after stack2.removeAfter(stack2.findNode(\"second\")):");
        StdOut.println(stack2);

        StdOut.println("stack3 from stack2.copy():");
        Stack<String> stack3 = stack2.copy();
        StdOut.println(stack3);

        StdOut.println("stack5 from stack2.copyDC():");
        Stack<String> stack5 = stack2.copyDC();
        StdOut.println(stack5);

        StdOut.println("stack3 after stack3.remove(\"forth\"):");
        stack3.remove("forth");
        StdOut.println(stack3);

        Stack<Integer> stack4 = new Stack<>();
        for (int i = 0; i < 5; i++) stack4.push(StdRandom.uniformInt(100));
        StdOut.println("stack4:\n" + stack4);
        StdOut.println("stack4.max()=" + stack4.max());
        StdOut.println();
        StdOut.println("stack4.maxRec()=" + stack4.maxRec());
        StdOut.println();

        StdOut.println("stack4.reverse():");
        stack4.reverse();
        StdOut.println(stack4);

        StdOut.println("stack4.reverseRecursive():");
        stack4.reverseRec();
        StdOut.println(stack4);

        StdOut.println("stack2.printReverseQuadratic():");
        stack2.printReverseQuadratic(stack2.first);
        StdOut.println();
        StdOut.println();

        StdOut.println("stack2.printReverseLinear():");
        stack2.printReverseLinear(stack2.first);
        StdOut.println();
        StdOut.println();

        StdOut.println("stack2.printReverseDivideAndConquer():");
        stack2.printReverseDivideAndConquer(stack2.first);
        StdOut.println();
        StdOut.println();

        StdOut.println("stack2:\n" + stack2);

        StdOut.println("stack2.shuffle():");
        stack2.shuffle();
        StdOut.println(stack2);
        StdOut.println("stack2.size(): " + stack2.size());
        StdOut.println();

        Stack<Integer> s1 = new Stack<>();
        for (int i = 1; i < 5; i++) {
            s1.push(i);
        }
        StdOut.println("s1:\n" + s1);
        StdOut.println("s1.pop(): " + s1.pop());
        StdOut.println("s1.size(): " + s1.size());
        StdOut.println();
        Stack<Integer> s2 = new Stack<>(s1);
        s2.push(9);
        StdOut.println("s2:\n" + s2);
        StdOut.println("s2.pop(): " + s2.pop());
        StdOut.println("s2.size(): " + s2.size());
    }
}
