public class testquizz {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1 + string2);

        int a = 2;
        int b = a;
        a = 7;
        StdOut.println(a + " " + b);

        int[] c = {1, 2, 3};
        int[] d = c;
        for (int i = 0; i < c.length; i++) {
            c[i] += 3;
            StdOut.print(c[i] + " ");
        }
        StdOut.println();
        for (int i = 0; i < d.length; i++) {
            StdOut.print(d[i] + " ");
        }
        StdOut.println();
    }
}
