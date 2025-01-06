public class app4318stack {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("forth");
        stack.push("fifth");

        if (stack.size() < k) throw new RuntimeException("Not enough strings in the input.");
        int index = stack.size() - k;
        for (int i = 0; i < index; i++) stack.pop();
        StdOut.println("The " + k + "-th from last string is: " + stack.pop());
    }
}
