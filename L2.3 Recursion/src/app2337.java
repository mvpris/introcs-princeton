import java.util.Arrays;

public class app2337 {

    // Returns the LCIS of two arrays arr1[0..n-1] and arr2[0..m-1]
    public static int[] LCIS(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        // table[j] is going to store the LCIS ending with arr2[j]
        int[] table = new int[m];

        // Initialize arrays to store previous indices for each element in arr2
        int[] prevIndex = new int[m];
        Arrays.fill(prevIndex, -1);

        // Traverse all elements of arr1[]
        int length = 0;
        int lastIndex = -1;
        for (int i = 0; i < n; i++) {
            // Initialize current length of LCIS
            int current = 0;
            int currentLastIndex = -1;

            // For each element of arr1[], traverse all elements of arr2[].
            for (int j = 0; j < m; j++) {
                // If both arrays have the same elements
                if (arr1[i] == arr2[j]) {
                    if (current + 1 > table[j]) {
                        table[j] = current + 1;
                        prevIndex[j] = currentLastIndex;
                    }
                }

                // Now seek for the previous smaller common element for the current element of arr1
                if (arr1[i] > arr2[j]) {
                    if (table[j] > current) {
                        current = table[j];
                        currentLastIndex = j;
                    }
                }
            }
        }

        // Determine the length of LCIS
        for (int i = 0; i < m; i++) {
            if (table[i] > length) {
                length = table[i];
                lastIndex = i;
            }
        }

        StdOut.println("table: " + Arrays.toString(table));
        StdOut.println("prevIndex: " + Arrays.toString(prevIndex));
        StdOut.println("length=" + length);
        StdOut.println("lastIndex=" + lastIndex);

        // Build the LCIS array
        int[] lcis = new int[length];
        int index = length - 1;
        while (lastIndex != -1) {
            lcis[index--] = arr2[lastIndex];
            lastIndex = prevIndex[lastIndex];
        }

        return lcis;
    }

    // Driver program to test above function
    public static void main(String[] args) {
//        int[] arr1 = {3, 4, 9, 10, 1};
//        int[] arr2 = {5, 3, 8, 9, 10, 2, 1};
        int[] arr1 = {1, 5, 3, 2, 7, 9, 4, 6, 10, 8, 11, 12};
        int[] arr2 = {5, 1, 3, 7, 4, 2, 11, 8, 6, 10, 9, 12};

        StdOut.println("arr1: " + Arrays.toString(arr1));
        StdOut.println("arr2: " + Arrays.toString(arr2));

        int[] result = LCIS(arr1, arr2);
        StdOut.println("LCIS: " + Arrays.toString(result));
    }
}
