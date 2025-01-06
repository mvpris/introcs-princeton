import java.awt.*;

public class app317 {
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        int w = picture.width();
        int h = picture.height();
//        boolean[][] grid = new boolean[w][h];
        int minX = w;
        int minY = h;
        int maxX = -1;
        int maxY = -1;

        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                Color color = picture.get(col, row);
                if (!color.equals(Color.white)) {
//                    grid[row][col] = true;
                    minX = Math.min(minX, col);
                    minY = Math.min(minY, row);
                    maxX = Math.max(maxX, col);
                    maxY = Math.max(maxY, row);
                }
            }
        }

        if (minX <= maxX && minY <= maxY) {
            System.out.println("The bounding box is from (" + minX + ", " + minY + ") to (" + maxX + ", " + maxY + ")");
        } else {
            System.out.println("No non-white pixels found.");
        }

    }
}
