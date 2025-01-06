public class app1524 {
    public static void main(String[] args) {
        String fileName = args[0];
        double rate = Double.parseDouble(args[1]);
        // Read the audio data from the specified .wav file
        double[] a = StdAudio.read(fileName);

        if (rate == 1) {
            // If rate is 1.0, play the original audio data
            StdAudio.play(a);
        } else {
            int newSize = (int) (a.length / rate);
            double[] b = new double[newSize];

            if (rate < 1.0) {
                // Populate b[] by downsampling from a[]
                for (int i = 0; i < newSize; i++) {
                    int j = (int) (i * rate);
                    b[i] = a[j];
                }
            } else {
                // Populate b[] by interpolating from a[]
                for (int i = 0; i < newSize - 1; i++) {
                    double x = i * rate;
                    int j = (int) x;
                    double y = x - j;
                    b[i] = (1 - y) * a[j] + y * a[j + 1];
                }
                // Handle the last element of b[] (interpolation)
                b[newSize - 1] = a[a.length - 1];
            }

            StdAudio.play(b);

//            java app1524 CantinaBand3.wav 1
        }
    }
}
