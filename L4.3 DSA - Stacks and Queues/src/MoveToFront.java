public class MoveToFront<Item> {
    private final Stack<Item> stack;

    public MoveToFront() {
        stack = new Stack<>();
    }

    public void push(Item item) {
        if (item.equals(stack.findItem(item))) {
            stack.remove(item);
        }
        stack.push(item);
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        Character[] a = {'a', 'b', 'c', 'd'};
        MoveToFront<Character> mtf = new MoveToFront<>();
        for (Character c : a) mtf.push(c);
        StdOut.println(mtf);
        mtf.push('x');
        StdOut.println(mtf);
        mtf.push('c');
        StdOut.println(mtf);
    }
}
