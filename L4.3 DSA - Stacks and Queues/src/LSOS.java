public class LSOS {
    private Node first;

    private class Node {
        private String item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public String toString() {
        String s = "";
        for (Node x = first; x != null; x = x.next) {
            s += x.item + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        LSOS stack = new LSOS();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else StdOut.print(stack.pop() + " ");
        }
        StdOut.println();
        StdOut.println(stack.toString());
    }
}
