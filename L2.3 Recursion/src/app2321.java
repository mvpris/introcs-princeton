public class app2321 {
    private static void generateBitStrings(String s, int k, int index, String current) {
        if (index == s.length()) {
            if (hammingDistance(s, current) == k) {
                System.out.println(current);
            }
            return;
        }

        // Flip the current bit and continue recursion
        generateBitStrings(s, k, index + 1, current + flipBit(s.charAt(index)));

        // Keep the current bit unchanged and continue recursion
        generateBitStrings(s, k, index + 1, current + s.charAt(index));
    }

    private static char flipBit(char bit) {
        return (bit == '0') ? '1' : '0';
    }

    private static int hammingDistance(String s1, String s2) {
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java HammingDistance <k> <bitString>");
            System.exit(1);
        }

        int k = Integer.parseInt(args[0]);
        String bitString = args[1];

        generateBitStrings(bitString, k, 0, "");
    }
}
