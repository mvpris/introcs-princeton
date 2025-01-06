public class app3134 {
    public static String removeUnnecessaryChars() {
        String text = "";
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            int wordLength = word.length();
            String newWord = "";
            for (int i = 0; i < wordLength; i++) {
                if (word.charAt(i) != '.' &&
                        word.charAt(i) != '!' &&
                        word.charAt(i) != '?' &&
                        word.charAt(i) != ',' &&
                        word.charAt(i) != '"' &&
                        word.charAt(i) != ':' &&
                        word.charAt(i) != ';' &&
                        word.charAt(i) != '(' &&
                        word.charAt(i) != ')' &&
                        word.charAt(i) != '-') {
                    newWord += word.charAt(i);
                }
            }
            text += newWord;
        }
        return text.toLowerCase();
    }

    public static int[] findFrequencies(String text) {
//        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
//                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] alphabet = {'a', 'c', 'g', 't'};
        int[] frequencies = new int[alphabet.length];
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (text.charAt(i) == alphabet[j]) {
                    frequencies[j]++;
                    break;
                }
            }
        }
        return frequencies;
    }

    public static double[] findProbabilities(String text, int[] frequencies) {
        double[] probabilities = new double[frequencies.length];
        for (int i = 0; i < frequencies.length; i++) {
            probabilities[i] = (double) frequencies[i] / text.length();
        }
        return probabilities;
    }

    public static double calculateEntropy(double[] probabilities) {
        double entropy = 0.0;
        for (int i = 0; i < probabilities.length; i++) {
            entropy -= probabilities[i] * log2(probabilities[i]);
        }
        return entropy;
    }

    public static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String text = in.readAll();
        int[] frequencies = findFrequencies(text);
        double[] probabilities = findProbabilities(text, frequencies);
        System.out.println("Entropy = " + calculateEntropy(probabilities));
    }
}
