public class MoveToFront2 {
    public static void main(String[] args) {
        Character[] a = {'a', 'b', 'c', 'd'};
        MoveToFront<Character> mtf = new MoveToFront<>();
        for (Character c : a) mtf.push(c);
        StdOut.println(mtf);
    }
}
