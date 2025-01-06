public class app1523 {
    public static void main(String[] args) {
        // Read a tune from StdIn and play it.
        double volume = Double.parseDouble(args[0]);
        double tempo = Double.parseDouble(args[1]);
        int SAMPLING_RATE = 44100;
        while (!StdIn.isEmpty()) { // Read and play one note.
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            duration *= tempo;
            double hz = 440 * Math.pow(2, pitch / 12.0);
            int n = (int) (SAMPLING_RATE * duration);
            double[] a = new double[n + 1];
            for (int i = 0; i <= n; i++) {
                a[i] = volume * Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);
            }
            StdAudio.play(a);
            StdAudio.save("elisee.wav", a);
        }
    }
}
