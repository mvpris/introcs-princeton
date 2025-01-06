public class Program1428 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(" a[" + i + "]");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("    " + a[i]);
        }
        System.out.println();

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[a[i]] = i;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(" b[" + i + "]");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("    " + b[i]);
        }
        System.out.println();

    }
}
