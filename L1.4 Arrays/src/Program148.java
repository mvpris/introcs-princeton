public class Program148 {
    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 1;
        System.out.print(a[0] + " " + a[1] + " ");
        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
