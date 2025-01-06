public class app2136 {
    public static void drawHalf(double x, double y) {
        StdDraw.filledRectangle(x, y, 0.375, 1);
    }

    public static void drawFull(double x, double y) {
        StdDraw.filledRectangle(x, y, 0.375, 2);
    }

    public static void barSeq(int digit, int count) {
        int[][] pseudoBinary = {
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0}
        };

        int countBar = 0;
        for (int i = 0; i < 5; i++) {
            if (pseudoBinary[digit][i] == 0) {
                drawHalf(1.65 + countBar + 5 * count, 1);
            } else {
                drawFull(1.65 + countBar + 5 * count, 2);
            }
            countBar++;
        }
    }

    public static int checksum(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return (sum % 10);
    }


    public static void main(String[] args) {
        String n = args[0];
        int nl = n.length();
        int[] digits = new int[nl];

        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(500, 100);
        if (nl == 5) StdDraw.setXscale(0, 32.25);
        else StdDraw.setXscale(0, 52.25);
        StdDraw.setYscale(0, 10);

        for (int i = 0; i < nl; i++) {
            digits[i] = Character.getNumericValue(n.charAt(i));
        }

        StdDraw.filledRectangle(0.65, 2, 0.375, 2);
        int j;
        for (j = 0; j < nl; j++) {
            barSeq(digits[j], j);
        }

        int checksumDigit = checksum(digits);
        barSeq(checksumDigit, j);
        StdDraw.filledRectangle(1.65 + 6 * nl, 2, 0.375, 2);

        for (int i = 0; i < nl; i++) {
            StdOut.print(digits[i]);
        }
        StdOut.print(checksumDigit);
        StdOut.println();

        StdDraw.show();
    }
}
