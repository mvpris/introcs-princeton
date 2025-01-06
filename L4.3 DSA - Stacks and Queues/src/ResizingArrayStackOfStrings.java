public class ResizingArrayStackOfStrings {
    private String[] items = new String[1];
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int capacity) {
        String[] temp = new String[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public void push(String item) {
        if (n == items.length) resize(2 * items.length);
        items[n++] = item;
    }

    public String pop() {
        String item = items[--n];
        items[n] = null;
        if (n > 0 && n == items.length / 4) resize(items.length / 2);
        return item;
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
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else StdOut.print(stack.pop() + " ");
        }
        StdOut.println();
        StdOut.println(stack.toString());
    }
}
