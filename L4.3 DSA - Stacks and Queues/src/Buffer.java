import java.util.NoSuchElementException;

public class Buffer {
    private Stack<Character> leftStack;
    private Stack<Character> rightStack;

    public Buffer() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
    }

    public void insert(char c) {
        leftStack.push(c);
    }

    public char delete() {
        if (!rightStack.isEmpty()) return rightStack.pop();
        else throw new NoSuchElementException("No character to delete.");
    }

    public void left(int k) {
        for (int i = 0; i < k && !leftStack.isEmpty(); i++) {
            rightStack.push(leftStack.pop());
        }
    }

    public void right(int k) {
        for (int i = 0; i < k && !rightStack.isEmpty(); i++) {
            leftStack.push(rightStack.pop());
        }
    }

    public int size() {
        return leftStack.size() + rightStack.size();
    }

    public void printBuffer() {
        StdOut.print("Buffer: ");
        printStack(leftStack);
        StdOut.print("|");
        printStack(rightStack);
        StdOut.println();
    }

    // Helper method to print stack contents in correct order
    private void printStack(Stack<Character> stack) {
        Stack<Character> tempStack = new Stack<>();
        for (char c : stack) {
            tempStack.push(c);
        }
        while (!tempStack.isEmpty()) {
            StdOut.print(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.printBuffer(); // Output: abc|

        buffer.left(2);
        buffer.printBuffer(); // Output: a|bc

        buffer.insert('x');
        buffer.printBuffer(); // Output: ax|bc

        buffer.right(1);
        buffer.printBuffer(); // Output: axb|c

        StdOut.println("Deleted: " + buffer.delete()); // Output: Deleted: c
        buffer.printBuffer(); // Output: axb|
    }
}
