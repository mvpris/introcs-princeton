public class AllShortestPaths {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT G = new GraphT(filename, delimiter);
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            String[] vertices = line.split("--");
            PathFinderT pf = new PathFinderT(G, vertices[0]);
            for (String s : pf.pathTo(vertices[1])) {
                StdOut.println("   " + s);
            }
        }
    }
    // input: java AllShortestPaths movies.txt "//"
    //        Bacon, Kevin--Kidman, Nicole
}
