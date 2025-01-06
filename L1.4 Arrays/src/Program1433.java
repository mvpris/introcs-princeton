public class Program1433 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * n);
            a[i] = r;
        }
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    count++;
                    if (count == 2) {
                        count2++;
                        System.out.print(a[i] + " " + a[j]);
                        break;
                    }
                }
            }
            if (count2 == 1) break;
        }
        System.out.println();
        System.out.println(count2);
        if (count2 >= 1) System.out.println("Yes");
        else System.out.println("No");

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
