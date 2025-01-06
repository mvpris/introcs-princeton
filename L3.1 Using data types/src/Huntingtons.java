public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int max = 0;
        int i = 0;
        while (i < dna.length() - 2) {
            String codon = dna.substring(i, i + 3);
            if (codon.equals("CAG")) {
                i += 3;
                count++;
                if (count > max) max = count;
            } else {
                i++;
                count = 0;
            }
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String s1 = s.replace("\n", "");
        String s2 = s1.replace("\t", "");
        return s2.replace(" ", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10 || maxRepeats > 180) return "not human";
        else if (maxRepeats < 36) return "normal";
        else if (maxRepeats < 40) return "high risk";
        else return "Huntington's";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        String s = in.readAll();
        String dna = removeWhitespace(s);
        int repeats = maxRepeats(dna);
        StdOut.println("max repeats = " + repeats);
        StdOut.println(diagnose(repeats));
    }
}
