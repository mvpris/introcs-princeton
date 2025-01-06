public class Program1438 {
    public static void main(String[] args) {
        int n = 1000000;
        int b = 365;
        int people = 0;
        for (int i = 0; i < n; i++) {
            boolean[] a = new boolean[b];
            while (true) {
                people++;
                int r = (int) (Math.random() * b);
                if (a[r]) break;
                a[r] = true;

//                System.out.println(r + " r");
//                System.out.println(people + " people");
            }
        }
        System.out.println(people / n + " people entered until two people share a birthday");
    }
}
