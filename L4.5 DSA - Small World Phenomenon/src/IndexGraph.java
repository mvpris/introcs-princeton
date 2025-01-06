public class IndexGraph {
    public static void main(String[] args) {
        // read in the graph from a file
        String filename = args[0];
        String delimiter = args[1];
        Graph G = new Graph(filename, delimiter);

        // read a vertex and print its neighbors
        while (!StdIn.isEmpty()) {
            String v = StdIn.readLine();
            if (G.hasVertex(v)) {
                for (String w : G.adjacentTo(v)) {
                    StdOut.println("  " + w);
                }
            }
        }
    }
}
