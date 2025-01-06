public class app447 {
    public static void main(String[] args) {
        String[] strings = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        int n = strings.length;
        int[] hashCodes = new int[n];
        for (int i = 0; i < n; i++) {
            hashCodes[i] = strings[i].hashCode();
            StdOut.print(hashCodes[i] + " ");
        }
        StdOut.println();
        int[] hashValues = new int[n];
        for (int i = 0; i < n; i++) {
            hashValues[i] = hashCodes[i] % 5;
            StdOut.print(hashValues[i] + "  ");
        }
        StdOut.println();
        for (String string : strings) {
            StdOut.print(string + "  ");
        }
        StdOut.println();
    }
}
