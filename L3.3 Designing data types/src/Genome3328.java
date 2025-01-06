public class Genome3328 {
    private final Vector profile;

    public Genome3328(String text) {
        int k = 4;
        int d = (int) Math.pow(4, k) - 1;
        int n = text.length();
        double[] freq = new double[d];
        for (int i = 0; i < n - k - 1; i++) {
            String kgram = text.substring(i, i + k);
            int hash = hash(kgram);
            freq[Math.abs(hash % d)] += 1;
        }
        Vector vector = new Vector(freq);
        profile = vector.direction();
    }

    public static int hash(String kgram) {
        int hashValue = 0;
        for (int i = 0; i < kgram.length(); i++) {
            hashValue *= 4;
            switch (kgram.charAt(i)) {
                case 'A':
                    hashValue += 0;
                    break;
                case 'C':
                    hashValue += 1;
                    break;
                case 'G':
                    hashValue += 2;
                    break;
                case 'T':
                    hashValue += 3;
                    break;
            }
        }
        return hashValue;
    }

    public static String unHash(int hashValue, int k) {
        StringBuilder kgram = new StringBuilder();
        for (int i = 0; i < k; i++) {
            switch (hashValue % 4) {
                case 0:
                    kgram.append('A');
                    break;
                case 1:
                    kgram.append('C');
                    break;
                case 2:
                    kgram.append('G');
                    break;
                case 3:
                    kgram.append('T');
                    break;
            }
            hashValue /= 4;
        }
        return kgram.reverse().toString();
    }

    public double similarTo(Genome3328 other) {
        return profile.dot(other.profile);
    }

    public String toString() {
        return profile.toString();
    }

    public static void main(String[] args) {
//        String s = args[0];
//        int hashValue = hash(s);
//        StdOut.println("hashValue=" + hashValue);
//        String unHashed = unHash(hashValue, s.length());
//        StdOut.println(unHashed);

//       Compare documents similar client
        String[] filenames = StdIn.readAllStrings();
        int n = filenames.length;
        Genome3328[] a = new Genome3328[n];
        for (int i = 0; i < n; i++)
            a[i] = new Genome3328(new In(filenames[i]).readAll());

        StdOut.print("    ");
        for (int j = 0; j < n; j++)
            StdOut.printf("%8.4s", filenames[j]);
        StdOut.println();

        for (int i = 0; i < n; i++) {
            StdOut.printf("%.4s", filenames[i]);
            for (int j = 0; j < n; j++)
                StdOut.printf("%8.2f", a[i].similarTo(a[j]));
            StdOut.println();
        }
    }
}
