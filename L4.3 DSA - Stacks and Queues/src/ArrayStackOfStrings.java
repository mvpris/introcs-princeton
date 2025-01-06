public class ArrayStackOfStrings {
    private final String[] items;
    private int n = 0;

    public ArrayStackOfStrings(int capacity) {
        items = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == items.length;
    }

    public void push(String item) {
        if (isFull())
            throw new RuntimeException("Stack is full.");
        items[n++] = item;
    }

    public String pop() {
        return items[--n];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += items[i] + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        int capacity = Integer.parseInt(args[0]);
        ArrayStackOfStrings stack = new ArrayStackOfStrings(capacity);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else StdOut.print(stack.pop() + " ");
        }
        StdOut.println();
        StdOut.println(stack.toString());
    }
}
