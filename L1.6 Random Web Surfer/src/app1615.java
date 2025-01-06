import java.util.Random;

public class app1615 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int hNl = Integer.parseInt(args[2]);
        int aNl = Integer.parseInt(args[3]);
        int[] hubsNumber = new int[hNl];
        int[] authNumber = new int[aNl];
        for (int i = 0; i < hNl; i++) {
            hubsNumber[i] = StdIn.readInt();
        }
        for (int i = 0; i < aNl; i++) {
            authNumber[i] = StdIn.readInt();
        }


        Random random = new Random();
        StdOut.print(n + " ");
        StdOut.println();

        for (int i = 0; i < n; i++) {
            int r1 = random.nextInt(n);
            while (i == r1) {
                r1 = random.nextInt(n);
            }
            StdOut.printf("%d %d  ", i, r1);
        }

        int hubs = (int) (0.1 * n);
        int authorities = (int) (0.1 * n);
        int hubsProd = hubs * hNl;
        int authProd = authorities * aNl;

        for (int i = 0; i < m - n - hubsProd - authProd; i++) {
            int r1 = random.nextInt(n);
            int r2 = random.nextInt(n);
            while (r1 == r2) {
                r1 = random.nextInt(n);
                r2 = random.nextInt(n);
            }
            StdOut.printf("%d %d  ", r1, r2);
        }


        for (int i = 0; i < hNl; i++) {
            for (int j = 0; j < hubs; j++) {
                int r1 = random.nextInt(n);
                while (hubsNumber[i] == r1) {
                    r1 = random.nextInt(n);
                }
                StdOut.printf("%d %d  ", r1, hubsNumber[i]);
            }
        }

        for (int i = 0; i < aNl; i++) {
            for (int j = 0; j < authorities; j++) {
                int r1 = random.nextInt(n);
                while (hubsNumber[i] == r1) {
                    r1 = random.nextInt(n);
                }
                StdOut.printf("%d %d  ", authNumber[i], r1);
            }
        }

        StdOut.println();

//        StdOut.println("hNl= " + hNl);
//        StdOut.print("hubsNumbers: ");
//        for (int i = 0; i < hNl; i++) {
//            StdOut.print(hubsNumber[i] + " ");
//        }
//        StdOut.println();
//
//        StdOut.println("aNl= " + aNl);
//        StdOut.print("authNumbers: ");
//        for (int i = 0; i < aNl; i++) {
//            StdOut.print(authNumber[i] + " ");
//        }
//        StdOut.println();
    }
}
