public class test2 {
    public static void main(String[] args) {
        In in = new In();
        while (!in.isEmpty()) {
            String[] s = in.readAllStrings();
            for (int i = 0; i < s.length; i++) {
                System.out.print(s[i] + " ");
            }
        }
    }
}
