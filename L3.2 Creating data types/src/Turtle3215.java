public class Turtle3215 {
    public static void main(String[] args) { // Draw a regular polygon with n sides.
        int n = Integer.parseInt(args[0]);
        double angle = 360.0 / n * 2;
        double step = Math.sin(Math.toRadians(angle / 2));
        Turtle turtle = new Turtle(0.5, 0.0, angle / 2);
        for (int i = 0; i < n; i++) {
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
    }
}
