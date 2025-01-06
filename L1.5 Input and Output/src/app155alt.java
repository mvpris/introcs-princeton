public class app155alt {
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        int currentNumLength = 1, longestNumLength = 1, longestNum = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                currentNumLength++;
            } else {
                if (currentNumLength > longestNumLength) {
                    longestNumLength = currentNumLength;
                    longestNum = a[i - 1];
                }
                currentNumLength = 1;
            }
        }
        if (currentNumLength > longestNumLength) {
            longestNumLength = currentNumLength;
            longestNum = a[a.length - 1];
        }
        StdOut.println("Longest run: " + longestNumLength + " consecutive " + longestNum + "s");
    }
}
