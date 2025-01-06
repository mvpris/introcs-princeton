public class DeDupArrays {
    public static String[] removeDuplicates(String[] a) {
        if (a.length == 0) return new String[0];

        int uniqueCount = 1;
        for (int i = 1; i < a.length; i++) {
            if (!a[i].equals(a[i - 1])) uniqueCount++;
        }

        String[] result = new String[uniqueCount];
        result[0] = a[0];
        int index = 1;
        for (int i = 1; i < a.length; i++) {
            if (!a[i].equals(a[i - 1])) {
                result[index] = a[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Mergesort.sort(a);
        String[] b = removeDuplicates(a);
        for (String s : b) StdOut.print(s + " ");
        StdOut.println();
    }
}
