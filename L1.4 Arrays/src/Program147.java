public class Program147 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
