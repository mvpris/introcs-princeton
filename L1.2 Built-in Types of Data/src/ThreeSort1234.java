public class ThreeSort1234 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int median = a + b + c - min - max;
        System.out.println("Ascending order = " + min + " " + median + " " + max);
    }
}
