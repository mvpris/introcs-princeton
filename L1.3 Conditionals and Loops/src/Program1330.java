public class Program1330 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        System.out.println(x);
    }
}
