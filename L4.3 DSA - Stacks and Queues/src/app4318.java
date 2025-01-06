public class app4318 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> queue = new Queue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        queue.enqueue("forth");
        queue.enqueue("fifth");

        if (queue.size() < k) throw new RuntimeException("Not enough strings in the input.");
        int index = queue.size() - k;
        for (int i = 0; i < index; i++) queue.dequeue();
        StdOut.println("The " + k + "-th from last string is: " + queue.dequeue());
    }
}
