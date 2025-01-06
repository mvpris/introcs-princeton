public class BbOOPclient {
    private final int n;
    private final BbOOP[] balls;

    public BbOOPclient(int n) {
        this.n = n;
        balls = new BbOOP[n];
        for (int i = 0; i < n; i++) {
            balls[i] = new BbOOP();
        }
    }

    public void moveBalls() {
        for (int i = 0; i < n; i++) {
            balls[i].move();
        }
    }

    public void draw() {
        for (int i = 0; i < n; i++) {
            balls[i].move();
            balls[i].draw();
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        BbOOPclient balls = new BbOOPclient(n);
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.GRAY);
        while (true) {
//            balls.moveBalls();
            balls.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
