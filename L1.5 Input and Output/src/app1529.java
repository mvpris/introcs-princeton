public class app1529 {
    public static void main(String[] args) {

//        Read elevation map from input file as multiple lines, split the lines by whitespace separator
//        and parse the integers into another array
        String[] map = StdIn.readAllLines();
        int n = map.length;
        String[][] map2 = new String[n][];
        for (int i = 0; i < n; i++) {
            map2[i] = map[i].split("\\s+");
        }
//        Parse the integers
        int[][] map3 = new int[n][];
        for (int i = 0; i < n; i++) {
            map3[i] = new int[map2[i].length];
            for (int j = 0; j < map2[i].length; j++) {
                map3[i][j] = Integer.parseInt(map2[i][j]);
            }
        }

//        Print the elevation map as read from input file
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < map2[i].length - 1; j++) {
                StdOut.print(map2[i][j] + " ");
            }
            StdOut.println();
        }

//        Read the peaks
        int peaks = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < map2[i].length - 1; j++) {
                if (map3[i][j - 1] < map3[i][j]
                        && map3[i][j + 1] < map3[i][j]
                        && map3[i - 1][j] < map3[i][j]
                        && map3[i + 1][j] < map3[i][j])
                    peaks++;
            }
        }
        StdOut.println("peaks=" + peaks);
    }
}
