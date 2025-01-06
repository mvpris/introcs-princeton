public class app4516 {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        GraphT G = new GraphT(filename, delimiter);

        SET<String> printedEdges = new SET<>();

        for (String v : G.vertices()) {
            for (String w : G.adjacentTo(v)) {
                String edge1 = v + " " + w;
                String edge2 = w + " " + v;
                if (!printedEdges.contains(edge1) && !printedEdges.contains(edge2)) {
                    StdOut.println(edge1);
                    printedEdges.add(edge1);
                }
            }
        }
    }
}
