public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> values = new Stack<>();
        while (!StdIn.isEmpty()) { // Read token, push if operator.
            String token = StdIn.readString();
            if (token.equals("(")) ;
            else if (token.equals("+")) ops.push(token);
            else if (token.equals("-")) ops.push(token);
            else if (token.equals("*")) ops.push(token);
            else if (token.equals("sqrt")) ops.push(token);
            else if (token.equals(")")) { // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = values.pop();
                if (op.equals("+")) v = values.pop() + v;
                else if (op.equals("-")) v = values.pop() - v;
                else if (op.equals("*")) v = values.pop() * v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                values.push(v);
            } // Token not operator or paren: push double value.
            else values.push(Double.parseDouble(token));
        }
        StdOut.println(values.pop());
//        java Evaluate
//        ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
//        101.0
    }
}
