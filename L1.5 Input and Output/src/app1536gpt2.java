import java.util.Random;

public class app1536gpt2 {
    public static void main(String[] args) {
        // Set the sample rate and duration of each note
        int sampleRate = 44100;
        double duration = 0.5;

        // Define the notes in the key of C major
        double[] notes = {261.63, 293.66, 329.63, 349.23, 392.00, 440.00, 493.88}; // C4, D4, E4, F4, G4, A4, B4

        // Create a random number generator
        Random random = new Random();

        // Initialize an array to store the audio samples
        double[] audioSamples = new double[0];

        // Keep track of the last played note
        double previousNote = -1;

        // Generate a random melody
        for (int i = 0; i < 16; i++) {
            int noteIndex;
            double nextNote;

            // Ensure the next note does not repeat immediately
            do {
                noteIndex = random.nextInt(notes.length);
                nextNote = notes[noteIndex];
            } while (nextNote == previousNote);

            // Generate audio samples for the note
            int numSamples = (int) (sampleRate * duration);
            double[] noteSamples = new double[numSamples];

            for (int j = 0; j < numSamples; j++) {
                noteSamples[j] = Math.sin(2 * Math.PI * j * nextNote / sampleRate);
            }

            // Concatenate the note samples to the audioSamples array
            int totalSamples = audioSamples.length + numSamples;
            double[] newAudioSamples = new double[totalSamples];
            System.arraycopy(audioSamples, 0, newAudioSamples, 0, audioSamples.length);
            System.arraycopy(noteSamples, 0, newAudioSamples, audioSamples.length, numSamples);
            audioSamples = newAudioSamples;

            // Update the previous note for the next iteration
            previousNote = nextNote;
        }

        // Play the generated melody
        StdAudio.play(audioSamples);
        for (double itk : notes) StdOut.print(itk + " ");
        StdOut.println();
    }
}
