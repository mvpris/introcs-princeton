public class app155 {
    public static void main(String[] args) {
        int prevNum, currentNum, longestNum = 0, currentNumLength = 1, longestNumLength = 1;
        if (!StdIn.isEmpty()) {
            prevNum = StdIn.readInt();
            while (!StdIn.isEmpty()) {
                currentNum = StdIn.readInt();
                if (currentNum == prevNum) {
                    currentNumLength++;
                } else {
                    if (currentNumLength > longestNumLength) {
                        longestNum = prevNum;
                        longestNumLength = currentNumLength;
                    }
                    currentNumLength = 1;
                }
                prevNum = currentNum;
            }
            if (currentNumLength > longestNumLength) {
                longestNum = prevNum;
                longestNumLength = currentNumLength;
            }
            StdOut.println("Longest run: " + longestNumLength + " consecutive " + longestNum + "s");
        } else StdOut.println("No input provided");
    }
}
