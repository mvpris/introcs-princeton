public class app1527gpt {
    public static void main(String[] args) {
        int SAMPLING_RATE = 44100;

        // Set up the canvas for visualization
        StdDraw.setCanvasSize(800, 400);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(-1, 1);

        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int n = (int) (SAMPLING_RATE * duration);
            double[] a = new double[n + 1];

            for (int i = 0; i <= n; i++) {
                a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);

                // Draw the sound wave as it's played
                StdDraw.line((double) i / n, 0, (double) i / n, a[i]);
            }

            // Play the audio
            StdAudio.play(a);

            // Clear the canvas to prepare for the next note
            StdDraw.clear();
        }
    }
}
