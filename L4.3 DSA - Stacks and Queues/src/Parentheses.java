public class Parentheses {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        String s = StdIn.readString();
        for (int i = 0; i < s.length(); i++) {
            char token = s.charAt(i);
            if (token == '(' || token == '[' || token == '{') {
                stack.push(token);
            } else if (token == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    flag = false;
                    break;
                }
            } else if (token == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    flag = false;
                    break;
                }
            } else if (token == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    flag = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            flag = false;
        }
        System.out.println("String of parentheses is properly balanced: " + flag);
    }
}
