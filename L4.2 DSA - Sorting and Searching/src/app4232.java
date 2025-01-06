import java.util.Arrays;

public class app4232 {
    public static boolean isSetPrefixFree(String[] a) { // Order of running time O(nlogn)
        Arrays.sort(a);                                 // O(nlogn)-linearithmic

        for (int i = 1; i < a.length; i++)
            if (a[i].startsWith(a[i - 1])) return true; // O(n)-linear
        return false;
    }

    public static void main(String[] args) {
        String[] set1 = {"01", "10", "0011", "1111"};
        String[] set2 = {"01", "10", "0010", "1010"};
        StdOut.println("Is set 'set1' prefix free=" + isSetPrefixFree(set1));
        StdOut.println("Is set 'set2' prefix free=" + isSetPrefixFree(set2));
    }
}
