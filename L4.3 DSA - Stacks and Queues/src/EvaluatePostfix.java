public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String token = StdIn.readString();
            if (token.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (token.equals("-")) stack.push(stack.pop() - stack.pop());
            else if (token.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (token.equals("/")) stack.push(stack.pop() / stack.pop());
            else stack.push(Integer.parseInt(token));
        }
        StdOut.println(stack.pop());
    }
}
