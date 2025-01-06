public class ThreeSum412 {
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

    public static void printTriplesTarget(int[] a, int target) {
        int n = a.length;
        int diff = Integer.MAX_VALUE;
        int temp_i = 0, temp_j = 0, temp_k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = a[i] + a[j] + a[k];
                    if (Math.abs(target - sum) < diff) {
                        temp_i = i;
                        temp_j = j;
                        temp_k = k;
                        diff = Math.abs(target - sum);
                    }
                }
            }
        }
        
        StdOut.println(a[temp_i] + " " + a[temp_j] + " " + a[temp_k]);
    }


    public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);
        int[] a = StdIn.readAllInts();
        printTriplesTarget(a, target);
    }
}
