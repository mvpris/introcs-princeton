public class Program1336 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = 1;
        for (int i = 3; i <= n; i += 2) {
            if (n % i == 0) ;
            else count++;
        }
        System.out.println(count);
    }
}
