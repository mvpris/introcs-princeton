import java.util.Arrays;

public class app4231 {
    public static int findLargestEmptyInterval(int[] a) {
        Arrays.sort(a);
        int maxInterval = Integer.MIN_VALUE;

        for (int i = 1; i < a.length; i++) {
            int diff = a[i] - a[i - 1];
            if (diff > maxInterval) maxInterval = diff;
        }
        return maxInterval;
    }

    public static void main(String[] args) {
        int[] timestamps = {1412553569, 1412560000, 1412580000, 1412670000}; // ints are representing miliseconds
        int interval = findLargestEmptyInterval(timestamps);
        StdOut.println("Largest empty inteval=" + interval + " miliseconds");
    }
}
