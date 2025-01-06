public class InfixToPostfix {
    public static void main(String[] args) {
        StdOut.println("Enter the expression:");
        String input = StdIn.readLine();

        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == ')') {
                String val2 = vals.pop();
                String op = ops.pop();
                String val1 = vals.pop();
                String subExpr = val1 + " " + val2 + " " + op;
                vals.push(subExpr);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                ops.push(String.valueOf(ch));
            } else if (Character.isDigit(ch)) {
                vals.push(String.valueOf(ch));
            }
        }

        StdOut.println("Equivalent infix expression with parentheses:");
        StdOut.println(vals.pop());
    }
}
