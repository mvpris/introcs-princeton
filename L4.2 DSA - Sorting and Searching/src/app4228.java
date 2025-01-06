import java.util.Arrays;

public class app4228 {
    public static void twoSumQuadratic(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == 0) StdOut.println("TwoSum pairQ=" + a[i] + "," + a[j]);
            }
        }
    }

    public static boolean isTwoSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = a[left] + a[right];

            if (sum == 0) return true;
            else if (sum < 0) left++;
            else right--;
        }
        return false;
    }

    public static void twoSumLinearithmic(int[] a) {
        Arrays.sort(a); // Step 1: Sort the array
        int n = a.length;

        int left = 0, right = n - 1;

        while (left < right) {  // Step 2: Use two pointers (two-pointer technique)
            int sum = a[left] + a[right];

            if (sum == 0) {
                StdOut.println("TwoSum pairL=" + a[left] + "," + a[right]);
                left++;
                right--;
            } else if (sum < 0) left++;
            else right--;
        }
    }

    public static boolean isTwoSumBinarySearch(int[] a) {
        Arrays.sort(a);
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(a, -a[i]);
            if (j > i) return true;
        }
        return false;
    }

    public static void findTwoSumBinarySearch(int[] a) {
        Arrays.sort(a);
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(a, -a[i]);
            if (j > i) StdOut.println("TwoSum pair BS=" + a[i] + "," + a[j]);
        }
    }

    public static void main(String[] args) {
//        In in = new In(args[0]);
//        int[] a = in.readAllInts();
        int[] a = {-3, 1, 2, -1, 5, -2};
        StdOut.println("isTwoSum(a)=" + isTwoSum(a));
        StdOut.println("isTwoSumBinarySearch(a)=" + isTwoSumBinarySearch(a));
        findTwoSumBinarySearch(a);
        twoSumQuadratic(a);
        twoSumLinearithmic(a);
    }
}
