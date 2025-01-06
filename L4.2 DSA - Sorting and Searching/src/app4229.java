import java.util.Arrays;

public class app4229 {
    public static boolean isThreeSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = a[i] + a[left] + a[right];

                if (sum == 0) return true;
                else if (sum < 0) left++;
                else right--;
            }
        }
        return false;
    }

    public static void findThreeSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;    //Skip duplicates

            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = a[i] + a[left] + a[right];

                if (sum == 0) {
                    StdOut.println("ThreeSum pair=" + a[i] + "," + a[left] + "," + a[right]);
                    while (left < right && a[left] == a[left + 1]) left++; // Skip duplicates
                    while (left < right && a[right] == a[right - 1]) right--; // Skip duplicates
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
    }

    public static boolean isThreeSumBinarySearch(int[] a) {
        Arrays.sort(a);
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k >= 0 && k > j) return true;
            }
        }
        return false;
    }

    public static void findThreeSumBinarySearch(int[] a) { // Does not handle duplicates and ignores integer overflow
        Arrays.sort(a);
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k >= 0 && k > j) StdOut.println(a[i] + "," + a[j] + "," + a[k]);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] b = {-1, -1, -1, -1, 0, 0, 0, 0, 1, 1, 1, 1};
        StdOut.println("isThreeSum(a)=" + isThreeSum(a));
        StdOut.println("isThreeSum(b)=" + isThreeSum(b));
        StdOut.println("isThreeSumBinarySearch(a)=" + isThreeSumBinarySearch(a));
        StdOut.println("isThreeSumBinarySearch(b)=" + isThreeSumBinarySearch(b));
        StdOut.println();
        StdOut.println("findThreeSum(a):");
        findThreeSum(a);
        StdOut.println();
        StdOut.println("findThreeSum(b):");
        findThreeSum(b);
        StdOut.println();
        StdOut.println("findThreeSumBinarySearch(a):");
        findThreeSumBinarySearch(a);
        StdOut.println();
        StdOut.println("findThreeSumBinarySearch(b):");
        findThreeSumBinarySearch(b);
    }
}
