import java.awt.*;

public class app3128 {
    public static void swap(Color a, Color b) {
        Color temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        Color c1 = Color.BLACK;
        Color c2 = Color.white;
        System.out.println(c1 + "=c1");
        System.out.println(c2 + "=c2");
        swap(c1, c2);
        System.out.println(c1 + "=c1s");
        System.out.println(c2 + "=c2s");
    }
}
