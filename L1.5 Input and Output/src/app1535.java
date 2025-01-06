public class app1535 {
    public static void main(String[] args) {

        String wallHitSound = "hit_wall.wav";
        String floorHitSound = "hit_floor.wav";

        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();
        double rx = 0.180, ry = 0.860;
        double vx = 0.015, vy = 0.023;
        double radius1 = 0.05;
        double radius2 = 0.04;
        int n = 1000;
        for (int i = 0; i < n; i++) {
            if (Math.abs(rx + vx) + radius1 > 1.0) {
                vx = -vx;
                StdAudio.play(wallHitSound);
            }
            if (Math.abs(ry + vy) + radius1 > 1.0) {
                vy = -vy;
                StdAudio.play(floorHitSound);
            }
            vy -= 0.005;
            rx += vx;
            ry += vy;
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledCircle(rx - vx, ry - vy, radius2);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius1);
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
