public class app437 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Stack<Integer> stack = new Stack<Integer>();
        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }
        while (!stack.isEmpty())
            StdOut.print(stack.pop());
        StdOut.println();
    }
}
