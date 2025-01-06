public class app4230 {
    public static void findMajorityInt(int[] a) {
        int n = a.length;
        int max_a = Integer.MIN_VALUE;
        for (int i : a) if (i > max_a) max_a = i;

        int[] b = new int[max_a + 1];
        for (int i : a) b[i]++;

        int max_b = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] > max_b) {
                max_b = b[i];
                result = i;
            }
        }
        if (b[result] > n / 2) StdOut.println("Majority int=" + result);
        else StdOut.println("No majority int found.");
    }

    public static String findMajorityString(String[] a) {   // Use the Boyer-Moore Voting Algorithm
        String candidate = null;
        int count = 0;

        // Phase 1: Find a candidate
        for (String s : a) {
            if (count == 0) {
                candidate = s;
                count = 1;
            } else if (s.equals(candidate)) {
                count++;
            } else {
                count--;
            }
        }


        // Phase 2: Verify the candidate
        count = 0;
        for (String s : a) {
            if (s.equals(candidate)) {
                count++;
            }
        }

        if (count > a.length / 2) {
            return candidate;
        } else {
            return null; // No majority string
        }
    }

    public static String findMajorityStringRecursive(String[] a) {  // Divide and conquer algorithm in O(nlogn)
        return majorityStringRecursive(a, 0, a.length - 1);
    }

    private static String majorityStringRecursive(String[] a, int left, int right) {
        if (left == right) return a[left];

        int mid = left + (right - left) / 2;
        String leftMajority = majorityStringRecursive(a, left, mid);
        String rightMajority = majorityStringRecursive(a, mid + 1, right);

        if (leftMajority.equals(rightMajority)) return leftMajority;

        int leftCount = countInRange(a, leftMajority, left, right);
        int rightCount = countInRange(a, rightMajority, left, right);

        if (leftCount > rightCount) return leftMajority;
        else return rightMajority;
    }

    private static int countInRange(String[] a, String s, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++)
            if (a[i].equals(s))
                count++;
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 3, 6, 6, 6, 6, 6, 9};
        findMajorityInt(a);

        String[] b = {"e", "c", "b", "b", "c", "x", "c", "c", "c", "f", "c"};
        String s = findMajorityString(b);
        if (s != null) StdOut.println("Majority string=" + s);
        else StdOut.println("No majority string found.");

        String sRecursive = findMajorityStringRecursive(b);
        if (sRecursive != null) StdOut.println("Majority string (recursive)=" + sRecursive);
        else StdOut.println("No majority string found.");
    }
}
