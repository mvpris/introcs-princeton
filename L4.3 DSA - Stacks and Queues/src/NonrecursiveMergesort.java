public class NonrecursiveMergesort {
    public static void main(String[] args) {
        String[] s = {"apple", "banana", "cherry", "apricot", "blueberry", "citrus"};
        int n = s.length;
        Queue<Queue<String>> qq = new Queue<>();
        for (int i = 0; i < n; i++) {
            Queue<String> q = new Queue<>();
            q.enqueue(s[i]);
            qq.enqueue(q);
        }
        Queue<String> temp;
        while (qq.size() != 1) {
            temp = MergeSortedQueues.mergeQueues(qq.dequeue(), qq.dequeue());
            qq.enqueue(temp);
        }
        StdOut.print(qq);
    }
}
