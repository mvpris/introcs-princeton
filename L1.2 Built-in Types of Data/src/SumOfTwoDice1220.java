public class SumOfTwoDice1220 {
    public static void main(String[] args) {
        int SIDES = 6;
        int a = 1 + (int) (Math.random() * SIDES);
        int b = 1 + (int) (Math.random() * SIDES);
        int sum = a + b;
        System.out.println("sum= " + sum);
        int c = (int) (0.99 * SIDES);
        System.out.println("(int)->not round c= " + c);
        int d = (int) (Math.round(0.99 * SIDES));
        System.out.println("(int)->rounded   d= " + d);
    }
}
