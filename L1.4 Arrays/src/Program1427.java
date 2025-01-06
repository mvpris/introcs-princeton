public class Program1427 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i = 1; i < n - 1; i++) {
            if (a[i - 1] > a[i] && a[i + 1] > a[i]) count++;
        }
        System.out.println(count);
    }
}
