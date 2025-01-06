public class DeDup {
    public static void deDup(String[] a) {
        Mergesort.sort(a);
        StdOut.print(a[0] + " ");
        for (int i = 1; i < a.length; i++)
            if (a[i].equals(a[i - 1])) StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Mergesort.sort(a);
        StdOut.print(a[0] + " ");
        for (int i = 1; i < a.length; i++)
            if (!a[i].equals(a[i - 1])) StdOut.print(a[i] + " ");
//          if (a[i].compareTo(a[i - 1]) != 0) StdOut.print(a[i] + " ");

//            equals() method is better suited because clarity: intent of equals() is to check for equality, whereas
//            intent of compareTo() is to check for order (for sorting). Both methods are efficient, just 1 extra step
//            for compareTo() when comparing the int value (result of compareTo()) to 0

        StdOut.println();
    }
}
