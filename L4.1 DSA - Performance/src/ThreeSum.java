public class ThreeSum {
    public static void printTriples(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if (a[i] + a[j] + a[k] == 0) StdOut.println(a[i] + " " + a[j] + " " + a[k]);
    }

    public static int countTriples(int[] a) { // Count triples that sum to 0.
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        count++;
        return count;
    }

    public static void randomIntGenerator(String filename, int n) {
        Out out = new Out(filename);
        for (int i = 0; i < n; i++) {
            out.println(StdRandom.uniformInt(-10000000, 10000000));
        }
    }

    public static void main(String[] args) {
//        randomIntGenerator("1kintss.txt", 1000);
        int[] a = StdIn.readAllInts();
        int count = countTriples(a);
        StdOut.println(count);
        if (count < 10) printTriples(a);
    }
}
