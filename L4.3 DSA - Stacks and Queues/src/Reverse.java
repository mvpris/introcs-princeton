public class Reverse {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            stack.push(s);
        }
        for (String s : stack) StdOut.print(s + " ");
        StdOut.println();
    }
}
