public class IndexGraphT {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT G = new GraphT(filename, delimiter);

        while (StdIn.hasNextLine()) {
            String v = StdIn.readLine();
            if (G.hasVertex(v)) {
                for (String w : G.adjacentTo(v)) {
                    StdOut.println("  " + w);
                }
            }
        }
    }
}
