public class Program1438eu {
    public static void main(String[] args) {
        int n = 1000000;
        int b = 365;
        int people = 0;
        for (int i = 0; i < n; i++) {
            boolean[] a = new boolean[b];
            int r = 0;
            while (!a[r]) {
                a[r] = true;
                r = (int) (Math.random() * b);
                people++;
//                System.out.println(r + " r");
//                System.out.println(people + " people");
//                corect e cum e in carte in Program1438 dar las aici si rezolvarea mea care da cu 1 in minus
            }
        }
        System.out.println(people / n + " people entered until two people share a birthday");
    }
}
