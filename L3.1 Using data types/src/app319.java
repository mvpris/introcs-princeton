public class app319 {
    public static boolean isValidDNA(String s) {
        int n = s.length();
        if (n == 0) return false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != 'A' && c != 'T' && c != 'C' && c != 'G') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidDNA("ATCG")); // Output: true
        System.out.println(isValidDNA("ATCGH")); // Output: false
        System.out.println(isValidDNA("ATCGTCGAAACC")); // Output: true
    }
}
