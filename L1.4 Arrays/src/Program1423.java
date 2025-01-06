public class Program1423 {
    public static void main(String[] args) {
        int[] a = {3, 3, 3, 3, 2, 2, 7, 7, 7, 7, 7, 7, 7, 7, 2, 2, 2};
        int n = a.length;
        boolean[] b = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) {
                b[i] = true;
                b[i + 1] = true;
            }
        }

//        Margins <
        for (int i = 1; i < n - 1; i++) {
            if (b[i]) {
                if (a[i - 1] > a[i]) {
                    b[i] = false;
                    while (a[i] == a[i + 1]) {
                        b[i + 1] = false;
                        i++;
                        if (i == n - 1) break;
                    }
                } else if (a[i + 1] > a[i]) {
                    b[i] = false;
                    while (a[i] == a[i - 1]) {
                        b[i - 1] = false;
                        i--;
                        if (i == 0) break;
                    }
                }
            }
        }

//        Count the longest streak
        int count = 0;
        int max = 0;
        int digit = 0;
        for (int i = 0; i < n; i++) {
            if (b[i]) count++;
            else count = 0;
            if (count > max) {
                max = count;
                digit = i;
            }
        }
        int position = digit - max + 1;

//        Print arrays
        for (int i = 0; i < n; i++) {
            if (i < 10) System.out.printf("  a[%1d]", i);
            else System.out.printf(" a[%2d]", i);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%6d", a[i]);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%6b", b[i]);
        }
        System.out.println();

//        Print position and length of the longest contiguous sequence of equal values
        System.out.println("Position = [" + position + "]");
        System.out.println("Length = " + max);
    }
}
