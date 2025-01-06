public class app4225test {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 9, 12, 6, 3};
        int key = Integer.parseInt(args[0]);
        int maxIndex = app4224.findMax(a, 0, a.length - 1);
        StdOut.println("maxIndex=" + maxIndex);
        int index = BinarySearchIntOrder.search(key, a, 0, maxIndex + 1, true);
        if (index != -1) StdOut.println("index=" + index);
        else StdOut.println("index=" + BinarySearchIntOrder.search(key, a, maxIndex + 1, a.length, false));
    }
}
