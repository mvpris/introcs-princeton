public class Program1314 {
    public static void main(String[] args) {
        int f = 0, g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println("f=" + f + "\t" + "g=" + g);
            f = f + g;
            g = f - g;
        }
    }
}
