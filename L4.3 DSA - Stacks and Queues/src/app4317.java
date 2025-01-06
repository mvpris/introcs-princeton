public class app4317 {
    public static Stack<String> copy(Stack<String> original) {
        Stack<String> temp = new Stack<>();
        Stack<String> copy = new Stack<>();

        for (String item : original) temp.push(item);
        for (String item : temp) copy.push(item);

        return copy;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        Stack<String> copiedStack = copy(stack);
        for (String s : stack) StdOut.print(s + " ");
        StdOut.println();
        for (String s : copiedStack) StdOut.print(s + " ");
        StdOut.println();
    }
}
