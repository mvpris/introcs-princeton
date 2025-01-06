public class app1528 {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        String[] voters = StdIn.readAllLines();
        int n = voters.length;
        for (int i = 0; i < m; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String t = voters[r];
            voters[r] = voters[i];
            voters[i] = t;
        }
        for (int i = 0; i < m; i++)
            StdOut.println(voters[i]);
    }
}
