import java.awt.*;

public class Charge3224 {
    public static void main(String[] args) {
//        // read in n point charges
//        int n = StdIn.readInt();
//        Charge[] a = new Charge[n];
//        for (int k = 0; k < n; k++) {
//            double x0 = StdIn.readDouble();
//            double y0 = StdIn.readDouble();
//            double q0 = StdIn.readDouble();
//            a[k] = new Charge(x0, y0, q0);
//        }
        int n = 3;
        Charge[] a = new Charge[n];
        a[0] = new Charge(0.4, 0.6, 50);
        a[1] = new Charge(0.5, 0.5, -5);
        a[2] = new Charge(0.6, 0.6, 50);

        for (int s = 0; s < 175; s++) {
            // compute the potential at each point and plot
            int SIZE = 800;
            Picture pic = new Picture(SIZE, SIZE);
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    double potential = 0.0;
                    for (int k = 0; k < n; k++) {
                        double x = 1.0 * i / SIZE;
                        double y = 1.0 * j / SIZE;
                        potential += a[k].potentialAt(x, y);
                    }
                    potential = 128 + potential / 2.0e10;
                    int t;
                    if (potential < 0) t = 0;
                    else if (potential > 255) t = 255;
                    else t = (int) potential;
//                    Color c = new Color(t, t, t);
//                    Color c = Color.getHSBColor(t / 255.0f, 0.9f, 0.9f);
//                 Color c = Color.getHSBColor(0.75f * t / 40, 0.8f, 0.8f);
                    int gray = (t * 37) % 255;
                    Color c = new Color(gray, gray, gray);
                    pic.set(i, SIZE - 1 - j, c);
                }
            }
            pic.show();
            a[1].increaseCharge(-2.0);
//            a[0].increaseCharge(-0.75);
//            a[1].increaseCharge(-0.5);
//            a[3].increaseCharge(1);
//            a[5].increaseCharge(-0.5);
//            a[6].increaseCharge(1);
//            a[8].increaseCharge(-0.5);
        }
    }
}
