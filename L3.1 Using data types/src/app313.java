import java.awt.*;

public class app313 {
    public static void main(String[] args) {
        int r1 = Integer.parseInt(args[0]);
        int g1 = Integer.parseInt(args[1]);
        int b1 = Integer.parseInt(args[2]);
        Color c1 = new Color(r1, g1, b1);
        int r2 = Integer.parseInt(args[3]);
        int g2 = Integer.parseInt(args[4]);
        int b2 = Integer.parseInt(args[5]);
        Color c2 = new Color(r2, g2, b2);
        int r3 = Integer.parseInt(args[6]);
        int g3 = Integer.parseInt(args[7]);
        int b3 = Integer.parseInt(args[8]);
        Color c3 = new Color(r3, g3, b3);

        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(0.75 / 3, 0.75 / 4, 0.125);
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(0.75 / 3, 0.75 / 4, 0.0675);

        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(2.25 / 3, 0.75 / 4, 0.125);
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(2.25 / 3, 0.75 / 4, 0.0675);

        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(0.75 / 3, 2.0 / 4, 0.125);
        StdDraw.setPenColor(c3);
        StdDraw.filledSquare(0.75 / 3, 2.0 / 4, 0.0675);

        StdDraw.setPenColor(c3);
        StdDraw.filledSquare(2.25 / 3, 2.0 / 4, 0.125);
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(2.25 / 3, 2.0 / 4, 0.0675);

        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(0.75 / 3, 3.25 / 4, 0.125);
        StdDraw.setPenColor(c3);
        StdDraw.filledSquare(0.75 / 3, 3.25 / 4, 0.0675);

        StdDraw.setPenColor(c3);
        StdDraw.filledSquare(2.25 / 3, 3.25 / 4, 0.125);
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(2.25 / 3, 3.25 / 4, 0.0675);

        // java app313 0 0 255 0 255 0 255 0 0

    }
}
