public class app438 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new Queue<>();
        while (!queue.isEmpty())
            stack.push(queue.dequeue());
        while (!stack.isEmpty())
            queue.enqueue(stack.pop());
    }
}
