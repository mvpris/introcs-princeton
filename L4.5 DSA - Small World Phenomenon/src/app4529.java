public class app4529 {
    public static SET<String> getConnectedMovies(GraphT graph, String actor) {
        PathFinderT pf = new PathFinderT(graph, actor);
        SET<String> connectedMovies = new SET<>();

        for (String v : graph.vertices()) {
            if (isMovieTitle(v) && pf.isReachable(v)) {
                connectedMovies.add(v);
            }
        }
        return connectedMovies;
    }

    private static boolean isMovieTitle(String v) {
        return v.matches(".*\\(\\d{4}\\)");
    }

    public static void filterMovies(String inputFilename, String outputFilename, String delimiter, String actor) {
        GraphT graph = new GraphT(inputFilename, delimiter);
        SET<String> connectedMovies = getConnectedMovies(graph, actor);

        In in = new In(inputFilename);
        Out out = new Out(outputFilename);

        while (in.hasNextLine()) {
            String line = in.readLine();
            String movie = line.split(delimiter)[0];

            if (connectedMovies.contains(movie)) out.println(line);
        }
        out.close();
    }

    public static void main(String[] args) {
        String inputFilename = args[0];
        String delimiter = args[1];
        String outputFilename = "filtered_movies.txt";
        String actor = "Bacon, Kevin";

        filterMovies(inputFilename, outputFilename, delimiter, actor);
        StdOut.println("Filtered movies have been written to " + outputFilename);
        // input: java app4529 movies.txt "//"
    }
}
